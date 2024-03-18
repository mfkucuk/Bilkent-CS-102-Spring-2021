/**
 * A class for testing different Shape2D objects.
 */
public class ShapeTest {

    /**
     * Calculates and returns the shape which has the largest area.
     * @param shapes is an array containing different Shape2D objects.
     * @return is Shape2D object with the largest area.
     */
    public static Shape2D findLargestArea( Shape2D[] shapes ) {
        double largest;

        largest = 0;
        for ( Shape2D s : shapes ) {
            if ( s.calculateArea() > largest ) {
                largest = s.calculateArea();
            }
        }

        for ( Shape2D s : shapes ) {
            if ( largest == s.calculateArea() ) {
                return s;
            }
        }

        return null;
    }

    /**
     * Calculates and returns the shape which has the largest perimeter.
     * @param shapes is an array containing different Shape2D objects.
     * @return is Shape2D object with the largest perimeter.
     */
    public static Shape2D findLargestPerimeter( Shape2D[] shapes ) {
        double largest;

        largest = 0;
        for ( Shape2D s : shapes ) {
            if ( s.calculatePerimeter() > largest ) {
                largest = s.calculatePerimeter();
            }
        }

        for ( Shape2D s : shapes ) {
            if ( largest == s.calculatePerimeter() ) {
                return s;
            }
        }

        return null;
    }
    public static void main(String[] args) throws Exception {
        
        // Variables
        Circle c;
        Square sq1;
        Square sq2;
        Square sq3;
        Square sq4;
        Rectangle r;
        Shape2D[] shapes;

        // Test for Shape2D
        c = new Circle( 13, 15, 7 );
        sq1 = new Square( -2, -5, 5 );
        sq2 = new Square( -2, -5, 5 );
        sq3 = new Square( -1, -5, 5 );
        sq4 = null;
        r = new Rectangle( 2, 3, 8, 15 );
        shapes = new Shape2D[]{ c, sq1, r };

        // toString method demonstration
        for ( Shape2D shape : shapes ) {
            System.out.println( shape );
        }

        // Calculate area and perimeter demonstration
        System.out.println( "Area of Square 2 is " + sq2.calculateArea() );
        System.out.println( "Perimeter of Rectangle is " + r.calculatePerimeter() );
        System.out.println( "Area of the Circle is " + c.calculateArea() );

        // Calculate distance demonstration
        System.out.println( "Distance between the circle and the square 1 is " + c.calculateDistance( sq1 ) );
        System.out.println( "Distance between the rectangle and the square 1 is " + r.calculateDistance( sq1 ) );
        System.out.println( "Distance between the circle and the rectangle is " + c.calculateDistance( r ) );
        System.out.println( "Distance between the square and the any object is " + c.calculateDistance( "Any object" ) );

        // equals demonstration
        System.out.println( "c.equals( c ) is " + c.equals( c ) );
        System.out.println( "sq1.equals( sq2 ) is " + sq1.equals( sq2 ) );
        System.out.println( "sq1.equals( sq3 ) is " + sq1.equals( sq3 ) );
        System.out.println( "sq1.equals( sq4 ) is " + sq1.equals( sq4 ) );
        System.out.println( "sq1.equals( r ) is " + sq1.equals( r ) );

        // Find largest demonstration
        System.out.println( "Shape with the largest area is " + findLargestArea( shapes ) );
        System.out.println( "Shape with the largest perimeter is " + findLargestPerimeter( shapes ) );

    }
}
