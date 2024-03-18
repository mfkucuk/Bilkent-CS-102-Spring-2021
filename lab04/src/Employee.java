/**
 * Employee class which extends from Person.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.05.2021
 */
public class Employee extends Person {
    
    // Properties
    final int MAX_JOBS = 5;
    int currentJobs;
    Delivery[] deliveries;
    double salary;
    int employeeNo;
    boolean available;
    
    // Constructor
    /**
     * A constructor initalizing employee object.
     * @param employeeNo is the unique number employee has.
     * @param name is the name of the employee.
     */
    public Employee( int employeeNo, String name ) {
        super( name );
        this.employeeNo = employeeNo;
        currentJobs = 0;
        deliveries = new Delivery[ MAX_JOBS ];
        adjustSalary( 100 );
        available = true;
    }

    // Methods
    /**
     * A method that changes employee's salary.
     * @param value is the new salary.
     */
    public void adjustSalary( double value ) {
        salary = value;
    }

    /**
     * Returns whether the employee is available or not.
     * @return is the availability.
     */
    public boolean getAvailability() {
        return available;
    }

    /**
     * Adds a new item to be delivered as a job.
     * @param sendItem depends on the weight. It is a mail if weight <= 0.1. A package otherwise.
     * @param sender is the person who ordered this deliver.
     * @param receiver is the person who is going to get the deliver.
     * @param packageNo is the package number.
     */
    public void addJob( Item sendItem, Customer sender, Customer receiver, int packageNo ) {
        if ( sendItem.getWeight() <= 0.1 ) {
            deliveries[currentJobs] = new Mail( sendItem.getContent(), sender, receiver, packageNo);
        }
        else {
            deliveries[currentJobs] = new Package( sendItem, sender, receiver, packageNo);
        }

        currentJobs++;
        if ( currentJobs >= MAX_JOBS ) {
            available = false;
        }
    }

    public void deliverPackages() {
        for ( int i = 0; i < MAX_JOBS; i++ ) {
            if ( deliveries[i] != null ) {
                System.out.println( deliveries[i] );
                System.out.println();
                currentJobs--;
                deliveries[i] = null;
                adjustSalary( salary + 10 );
            }
        }
        available = true;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nCurrent Jobs: " + currentJobs + "\nSalary: " + salary
            + "\nEmployee No: " + employeeNo;
    }

}
