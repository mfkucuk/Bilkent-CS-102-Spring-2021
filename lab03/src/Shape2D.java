/**
 * An implementation of the 2D shapes.
 * @author Mehmet Feyyaz Kucuk
 * @version 26.02.2021
 */
public abstract class Shape2D {

    // Properties
    protected int x;
    protected int y;

    // Constructors

    /**
     * A constructor initalizing shape's center's coordinates.
     * @param x is the x-coordinate of the shape's center.
     * @param y is the y-coordinate of the shape's center.
     */
    public Shape2D( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    // Methods
    
    /**
     * Calculates and returns the perimeter of the 2D shape.
     * @return is the perimeter of the 2D shape.
     */
    public abstract double calculatePerimeter();

    /**
     * Calculates and returns the area of the 2D shape.
     * @return is the area of the 2D shape.
     */
    public abstract double calculateArea();

    /**
     * Calculates and returns the distance between two shapes' centers.
     * @param anyShape is the second shape.
     * @return is the distance between centers.
     */
    public double calculateDistance( Object anyShape ) {
        if ( ! (anyShape instanceof Shape2D) ) {
            return -1;
        }

        return Math.sqrt( Math.pow( x - ((Shape2D) anyShape).x, 2 ) + Math.pow( y - ((Shape2D) anyShape).y, 2 ) );
    }

    @Override
    /**
     * String representation of the Shape2D object.
     * @return is the string representation.
     */
    public String toString() {
        return "[" + this.getClass() + "]" + "x = " + x + ", y = " + y;
    }

    @Override
    /**
     * Checks if both Shape2D objects have the same center.
     * @param o is the other object to be compared with.
     * @return is the boolean indicating the result.
     */
    public boolean equals( Object o ) {
        if ( o instanceof Shape2D ) {
            return x == ((Shape2D) o).x && y == ((Shape2D) o).y;
        }
        return false;
    }

}