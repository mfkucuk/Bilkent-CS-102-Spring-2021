/**
 * An abstract class that creates deliveries.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public abstract class Delivery {
    
    // Properties
    int packageNo;
    Customer sender;
    Customer receiver;

    // Constructor
    /**
     * A constructor initalizing all the properties of delivery object.
     * @param sender
     * @param receiver
     * @param packageNo
     */
    public Delivery( Customer sender, Customer receiver, int packageNo ) {
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }

    // Methods
    /**
     * Get method for the package number.
     * @return is the value of the packageNo.
     */
    public int getPackageNo() {
        return packageNo;
    }

    /**
     * Get method for the sender.
     * @return is the sender.
     */
    public Customer getSender() {
        return sender;
    }

    /**
     * Returns the receiver.
     * @return is the receiver.
     */
    public Customer getReceiver() {
        return receiver;
    }

    /**
     * Returns the weight.
     * @return is the weight.
     */
    abstract double getWeight();

}
