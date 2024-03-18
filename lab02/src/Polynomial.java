package src;

import java.util.Arrays;

/**
 * An implementation of polynomials.
 * @author Mehmet Feyyaz Kucuk - 22003550
*/
public class Polynomial
{
    // Properties
    private double[] coefficients;
    
    // Constructors
    
    /**
     * A constructor for forming polynomial with one coefficient.
     * @param d is the degree.
     * @param c is the coefficient.
    */ 
    public Polynomial( int d, double c ) {
        coefficients = new double[d + 1];
        coefficients[d] = c;
    }
    
    /**
     * A constuctor for forming zero polynomial. 
    */ 
    public Polynomial() {
        coefficients = new double[1];
        coefficients[0] = 0;
    }
    
    /**
     * A constructor for forming polynomial with multiple coefficients.
     * @param coefficients is array for the coefficients.
    */ 
    public Polynomial( double[] coefficients ) {
        this.coefficients = Arrays.copyOf( coefficients, coefficients.length );
    }
    
    // Methods
    
    /**
     * Returns the coefficient of the specified degree. returns 0 if that degree doesn't exist.
     * @param d is the specified degree.
     * @return is the coefficient of the specified degree.
     */ 
    public double getCoefficient( int d ) {
        double result;

        if ( d > coefficients.length - 1 ) {
            return 0;
        }
        
        result = coefficients[d];
        return result;
    }
    
    /**
     * Returns the highest degree of the polynomial.
     * @return is the highest degree.
     */ 
    public int getDegree() {
        int result;
        
        result = coefficients.length - 1;
        
        return result;
    }
    
    /**
     * Returns the string representation of the polynomial.
     * @return is the string polynomial.
     */ 
    public String toString() {
        String result;
        boolean isFirstElement;
        
        result = "";
        isFirstElement = true;
        if ( coefficients.length == 1 && coefficients[0] == 0 ) {
            result = "0";
            return result;
        }

        for ( int d = 0; d < coefficients.length; d++ ) {
            if ( coefficients[d] != 0 ) {
                if ( d == 0 ) {
                    result = result + coefficients[0];
                }
                else {
                    if ( ! isFirstElement ) {
                        if ( coefficients[d] > 0 ) {
                            result = result + " + " + coefficients[d] + "x^"+ d;
                        }
                        else {
                            result = result + " - " + Math.abs(coefficients[d]) + "x^"+ d;
                        }
                    }
                    else {
                        if ( coefficients[d] > 0 ) {
                            result = result + coefficients[d] + "x^"+ d;
                        }
                        else {
                            result = result + " - " + Math.abs(coefficients[d]) + "x^"+ d;
                        }
                    }
                }
                isFirstElement = false;
            }
        }
        
        return result;
    }
    
    /**
     * Returns the value of the polynomial at the given x.
     * @param x is the input value for the polynomial.
     * @return is value of the polynomial at x.
     */ 
    public double eval( double x ) {
        double result;
        
        result = 0;
        for ( int d = 0; d < coefficients.length; d++ ) {
            result = result + coefficients[d] * Math.pow( x, d );
        }
        
        return result;
    }
    
    /**
     * Returns the value of the polynomial at the given x using Horner's method.
     * @param x is the input value for the polynomial.
     * @return is value of the polynomial at x computed from Horner's method.
     */ 
    public double eval2( double x ) {
        double result;
        
        result = coefficients[coefficients.length - 1];
        for ( int d = coefficients.length - 2; d >= 0; d-- ) {
            result = result * x + coefficients[d];
        }
        
        return result;
    }

    /**
     * Adds up two polynomials and returns the sum.
     * @param p2 is the polynomial to be added.
     * @return is the sum.
     */
    public Polynomial add( Polynomial p2 ) {
        double[] result;
        double[] smaller;

        if ( this.getDegree() > p2.getDegree() ) {
            result = Arrays.copyOf( coefficients, coefficients.length );
            smaller = Arrays.copyOf( p2.coefficients, p2.coefficients.length );
        }
        else {
            result = Arrays.copyOf( p2.coefficients, p2.coefficients.length );
            smaller = Arrays.copyOf( coefficients, coefficients.length );
        }

        for ( int d = 0; d < smaller.length; d++ ) {
            result[d] += smaller[d];
        }

        return new Polynomial( result );
    }

    /**
     * Subtracts the argument polynomial from the called polynomial.
     * @param p2 is the polynomial to be subtracted.
     * @return is the remainder.
     */
    public Polynomial sub( Polynomial p2 ) {
        Polynomial result;

        for ( int d = 0; d < p2.coefficients.length; d++ ) {
            p2.coefficients[d] = - p2.coefficients[d];
        }
        result = this.add( p2 );

        return result;
    }

    /**
     * Multiplies two polynomials together.
     * @param p2 is the polynomial to be multiplied with.
     * @re the product.
     */
    public Polynomial mul( Polynomial p2 ) {
        double[] result;

        result = new double[ this.getDegree() + p2.getDegree() + 1 ];
        for ( int d = 0; d < coefficients.length; d++ ) {
            for ( int i = 0; i < p2.coefficients.length; i++ ) {
                result[ i + d ] += coefficients[d] * p2.coefficients[i]; 
            }
        }

        return new Polynomial( result );
    }

    /**
     * Composes two polynomial and returns the composite polynomial.
     * @param p2 is the polynomial to compose called polynomial with.
     * @return is the composite polynomial.
     */
    public Polynomial compose( Polynomial p2 ) {
        Polynomial result;
        Polynomial temp;

        result = new Polynomial();
        temp = p2;
        result = result.add( new Polynomial( 0, coefficients[0] ) );
        for ( int d = 1; d < coefficients.length; d++ ) {
            result = result.add( new Polynomial( 0, coefficients[d] ).mul( temp ) );
            temp = temp.mul( p2 );
        }

        return result;
    }

    /**
     * Divides the called polynomial to the p2. (Remainder is ignored.)
     * @param p2 is the divisor polynomial.
     * @return is the result of the quotient.
     */
    public Polynomial div( Polynomial p2 ) {
        Polynomial result;
        Polynomial temp; // leadP(x) / leadQ(x)
        Polynomial p1; // P(x)
        Polynomial leadFirst; // leadP(x)
        Polynomial leadSecond; // leadQ(x) 
        int len;

        result = new Polynomial();
        p1 = this;
        leadSecond = new Polynomial( p2.getDegree(), p2.getCoefficient( p2.getDegree() ) );
        len = p1.getDegree();
        while ( len >= p2.getDegree() ) {
            leadFirst = new Polynomial( len, p1.getCoefficient( len ) );

            temp = new Polynomial( leadFirst.getDegree() - leadSecond.getDegree(), leadFirst.getCoefficient( leadFirst.getDegree() ) / leadSecond.getCoefficient( leadSecond.getDegree() ) ) ;
            p1 = p1.sub( p2.mul( temp ) );
            result = result.add( temp );
            len--;
        }

        return result;
    }
}
