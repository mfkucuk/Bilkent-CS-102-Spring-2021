/**
 * An Item class
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public class Item {

    // Properties
    double weight;
    String content;

    // Constructor
    
    /**
     * A constructor which sets the properties of item instance.
     * @param weight is the weight of the item.
     * @param content is the content of the item.
     */
    public Item( double weight, String content ) {
        this.weight = weight;
        this.content = content;
    }

    // Methods
    /**
     * Get method for weight property
     * @return is weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Get method for content property
     * @return is content.
     */
    public String getContent() {
        return content;
    }

    @Override
    /**
     * String representation of the the item object.
     * @return is the string.
     */
    public String toString() {
        return "Weight: " + weight + "\nContent: " + content;
    }

}
