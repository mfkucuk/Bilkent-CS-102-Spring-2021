package src;

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
        double[] e = { 0, 0, 6, -4, 5, 3 };
        double[] e1 = { 3, 4, 1, 3, 0, 2 };
        double[] e2 = { 2, 1 };
        
        Polynomial p1 = new Polynomial( 3, 6 );
        Polynomial p2 = new Polynomial();
        Polynomial p3 = new Polynomial( e );
        Polynomial p4 = new Polynomial( e1 );
        Polynomial p5 = new Polynomial( e2 );
        
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
        
        // Polynomial four operations
        System.out.println( "p1 + p3 = " + p1.add( p3 ) );
        System.out.println( "p4 - p3 = " + p4.sub( p3 ) );
        System.out.println( "p4 * p5 = " + p4.mul( p5 ) );
        System.out.println( "p4 / p5 = " + p4.div( p5 ) );

        // Composite of polynomials
        System.out.println( "p3 ( p1 ) = " + p3.compose( p1 ) );
    }
}