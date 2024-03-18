/**
 * An abstract class representing real-life people.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public abstract class Person implements Locatable {
    
    // Properties
    String name;
    int posX;
    int posY;

    // Constructors
    /**
     * A constructor setting all the properties of Person object.
     * @param name is the name of the person.
     * @param x is the x position of the person.
     * @param y is the y position of the person.
     */
    public Person( String name, int x, int y ) {
        this.name = name;
        posX = x;
        posY = y;
    }

    /**
     * A constructor setting name and positions to 0.
     * @param name is the name of the person.
     */
    public Person( String name ) {
        this.name = name;
        posX = 0;
        posY = 0;
    }

    // Methods
    /**
     * Get method for the name property.
     * @return is the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set method for the name property.
     * @param name is the new name to be set.
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * Get method for the x position.
     * @return is the x-coordinate.
     */
    public int getX() {
        return posX;
    }

    /**
     * Get method for the y position.
     * @return is the y-coordinate.
     */
    public int getY() {
        return posY;
    }

    /**
     * Set method for the position of the Person.
     * @param x is the x position.
     * @param y is the y position.
     */
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }

}
