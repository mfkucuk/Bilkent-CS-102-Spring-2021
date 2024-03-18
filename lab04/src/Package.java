/**
 * A class for the package to be delivered.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public class Package extends Delivery {
    
    // Properties
    Item packedItem;

    // Constructor
    /**
     * Initalises all the properties of package object using delivery constructor.
     * @param content is the content of item being delivered.
     * @param sender is the sender of package.
     * @param receiver is the receiver of package.
     * @param packageNo is the package number of the package
     */
    public Package( Item content, Customer sender, Customer receiver, int packageNo ) {
        super( sender, receiver, packageNo );
        packedItem = content;
    }

    // Methods
    /**
     * Returns the weight of the package.
     * @return is the weight.
     */
    public double getWeight() {
        return packedItem.getWeight();
    }

    @Override
    /**
     * String representation of the package object.
     * @return is the string.
     */
    public String toString() {
        return "Package Content: " + packedItem.getContent() + "\nSender: " + sender + "\nReceiver: " + receiver
            + "\nPackage No: " + packageNo;
    }

}
