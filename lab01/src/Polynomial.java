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
     * @return result is the coefficient of the specified degree.
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
     * @return result is the highest degree.
     */ 
    public int getDegree() {
        int result;
        
        result = coefficients.length - 1;
        
        return result;
    }
    
    /**
     * Returns the string representation of the polynomial.
     * @return result is the string polynomial.
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
     * @return result is value of the polynomial at x.
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
     * @return result is value of the polynomial at x computed from Horner's method.
     */ 
    public double eval2( double x ) {
        double result;
        
        result = coefficients[coefficients.length - 1];
        for ( int d = coefficients.length - 2; d >= 0; d-- ) {
            result = result * x + coefficients[d];
        }
        
        return result;
    }
}