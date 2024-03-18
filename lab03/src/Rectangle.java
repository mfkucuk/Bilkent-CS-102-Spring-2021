/**
 * A rectangle class which extends Shape2D abstract class.
 * @author Mehmet Feyyaz Kucuk
 * @version 26.02.2021
 */
public class Rectangle extends Shape2D {

    // Properties
    protected double width;
    protected double height;

    // Constructors

    /**
     * A constructor initalizing rectangle's center's coordinates, width and height.
     * @param x is the x-coordinate of the rectangle's center.
     * @param y is the y-coordinate of the rectangle's center.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     */
    public Rectangle( int x, int y, double width, double height ) {
        super( x, y );
        this.width = width;
        this.height = height;
    }

    // Methods

    /**
     * Calculates and returns the rectangle object's perimeter.
     * @return is the perimeter.
     */
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    /**
     * Calculates and returns the rectangle object's area.
     * @return is the area.
     */
    public double calculateArea() {
        return width * height;
    }

    @Override
    /**
     * String representation of the rectangle object.
     * @return is the string representation.
     */
    public String toString() {
        return super.toString() + ", width = " + width + " and height = " + height;
    }

    @Override
    /**
     * Compares rectangle object with any object.
     * @param o is the object.
     * @return is the boolean indicating the result.
     */
    public boolean equals( Object o ) {
        if ( o instanceof Rectangle ) {
            return super.equals( o ) && width == ((Rectangle) o).width && height == ((Rectangle) o).height;
        }
        
        return false;
    }
    
}
