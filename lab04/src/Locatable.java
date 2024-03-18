/**
 * An interface for locatable items.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public interface Locatable {

    // Methods

    /**
     * Returns the x position of a locatable.
     * @return is the x-coordinate.
     */
    int getX();

    /**
     * Returns the y position of a locatable.
     * @return is the y-coordinate.
     */
    int getY();

    /**
     * Sets a new position for the locatable.
     * @param x is the new x-coordinate.
     * @param y is the new y-coordinate.
     */
    void setPos( int x, int y );

}