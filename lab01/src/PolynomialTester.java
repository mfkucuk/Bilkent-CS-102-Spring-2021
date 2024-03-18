/**
 * A tester class for testing polynomials
 * @author Mehmet Feyyaz Kucuk - 22003550
 * @version 06.02.2021
 */ 
public class PolynomialTester {
    
    /**
     * A function for demonstrating the properties of polynomials.
     * @param p is the polynomial.
     * @param x is the eval value for the polynomial at that point. 
     */
    public static void showPolynomial( Polynomial p, int x ) {
        System.out.println( "---------------------------------------" );
        System.out.println( "String representation: " + p );
        System.out.println( "Degree: " + p.getDegree() );
        System.out.println( "Value at " + x + ": " + p.eval( x ) );
        System.out.println( "Value at " + x + " using Horner's Method: " + p.eval2( x ) );
        System.out.println( "---------------------------------------" );
        System.out.println();
    }
    public static void main(String[] args) {

        // Variables
        double[] e = { 5, 7, 6, -4, 5, 3 };
        
        Polynomial p1 = new Polynomial( 3, 6 );
        Polynomial p2 = new Polynomial();
        Polynomial p3 = new Polynomial( e );
        
        // Program Code
        
        // Polynomial with one coefficient
        System.out.println( "Polynomial with single coefficient" );
        showPolynomial( p1, 4 );
        
        // Zero polynomial
        System.out.println( "Zero Polynomial" );
        showPolynomial( p2, 3 );
        
        // Polynomial with multiple coefficients
        System.out.println( "Polynomial with multiple coefficients" );
        showPolynomial( p3, 2 );
        System.out.println( p3.getCoefficient( 5 ) );
    }
}
