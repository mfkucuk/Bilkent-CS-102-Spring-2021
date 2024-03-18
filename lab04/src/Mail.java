/**
 * A mail class which carries out the delivery.
 */
public class Mail extends Delivery {
    
    // Properties
    String content;

    // Constructor
    /**
     * Sets all the properties of mail using delivery constructor.
     * @param content is the content of the mail.
     * @param sender is sender of the mail.
     * @param receiver is receiver of the mail.
     * @param packageNo is the package number of the mail.
     */
    public Mail( String content, Customer sender, Customer receiver, int packageNo ) {
        super( sender, receiver, packageNo );
        this.content = content;
    }

    // Methods
    /**
     * Returns 0.1, independent from the content.
     */
    public double getWeight() {
        return 0.1;
    }

    @Override
    /**
     * String representation of the mail object.
     * @return is the string.
     */
    public String toString() {
        return "Mail Content: " + content + "\nSender: " + sender + "\nReceiver: " +
            receiver + "\nPackage No: " + packageNo;
    }

}
