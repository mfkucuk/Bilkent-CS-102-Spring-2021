/**
 * A class representing a customer which extends from abstract Person class.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public class Customer extends Person {
    
    // Properties
    Item currentItem;

    // Constructor
    /**
     * A constructor setting the properties of customer using person constructor.
     * @param name is the of the customer.
     */
    public Customer( String name ) {
        super( name );
    }

    // Methods
    /**
     * Get method for the current item.
     * @return is the current item customer has.
     */
    public Item getCurrentItem() {
        return currentItem;
    }

    /**
     * Set method for the current item.
     * @param currentItem is the new item to be set.
     */
    public void setCurrentItem( Item currentItem ) {
        this.currentItem = currentItem;
    }

    /**
     * Sends an item to desired customer.
     * @param company is the delivery company.
     * @param item is the item to be sent.
     * @param receiver is who ic going to receive the delivery.
     * @return indicates if everything went ok.
     */
    public boolean sendItem( Company company, Item item, Customer receiver ) {
        return company.createDeliverable( item, this, receiver );
    }

    @Override
    /**
     * Return string representation of the customer
     * @return is customer info.
     */
    public String toString() {
        return "Name: " + getName() + "\tX: " + getX() + "\tY: " + getY();
    }

}
