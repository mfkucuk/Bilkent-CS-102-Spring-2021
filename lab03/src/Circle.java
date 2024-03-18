/**
 * A circle class which extends Shape2D abstract class.
 */
public class Circle extends Shape2D {
    
    // Properties
    protected double radius;

    // Constructor
    /**
     * A constructor initalizing cirlce's center's coordinates and radius.
     * @param x is the x-coordinate of the circle's center.
     * @param y is the y-coordinate of the cirlce's center. 
     * @param radius is the radius of the circle.
     */
    public Circle( int x, int y, double radius ) {
        super( x, y );
        this.radius = radius;
    }

    // Methods

    /**
     * Calculates and returns the circle object's perimeter.
     * @return is the perimeter.
     */
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates and returns the circle object's area.
     * @return is the area.
     */
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    /**
     * String representation of the circle object.
     * @return is the string representation.
     */
    public String toString() {
        return super.toString() + " and radius = " + radius;
    }

    @Override
    /**
     * Compares circle object with any object.
     * @param o is the object.
     * @return is the boolean indicating the result.
     */
    public boolean equals( Object o ) {
        if ( o instanceof Circle ) {
            return super.equals( o ) && radius == ((Circle) o).radius;
        }
        
        return false;
    }

}
