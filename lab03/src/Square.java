/**
 * A square class which extends Shape2D abstract class.
 * @author Mehmet Feyyaz Kucuk
 * @version 26.02.2021
 */
public class Square extends Shape2D {
    
    // Properties
    protected double sideLength;

    // Constructors
    
    /**
     * A constructor initalizing square's center's coordinates and side length.
     * @param x is the x-coordinate of the square's center.
     * @param y is the y-coordinate of the square's center.
     * @param sideLength is the length of one side of the square.
     */
    public Square( int x, int y, double sideLength ) {
        super( x, y );
        this.sideLength = sideLength;
    }

    // Methods

    /**
     * Calculates and returns the square object's perimeter.
     * @return is the perimeter.
     */
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    /**
     * Calculates and returns the square object's area.
     * @return is the area.
     */
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    /**
     * String representation of the square object.
     * @return is the string representation.
     */
    public String toString() {
        return super.toString() + " and side = " + sideLength;
    }

    @Override
    /**
     * Compares square object with any object.
     * @param o is the object.
     * @return is the boolean indicating the result.
     */
    public boolean equals( Object o ) {
        if ( o instanceof Square ) {
            return super.equals( o ) && sideLength == ((Square) o).sideLength;
        }
        
        return false;
    }

}
