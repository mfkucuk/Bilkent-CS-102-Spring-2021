import java.util.ArrayList;

/**
 * A Locatable Company class which contains people.
 */
public class Company implements Locatable {
    
    // Properties
    final int EMPLOYEE_CAPACITY = 15;
    Employee[] employees;
    ArrayList<Customer> customers;
    int numOfEmployees;
    int employeeNo;
    int packageNo;
    int posX;
    int posY;

    // Constructor
    /**
     * Sets the position of the company.
     * @param x is the x-coordinate.
     * @param y is the y-coordinate.
     */
    public Company( int x, int y ) {
        employees = new Employee[ EMPLOYEE_CAPACITY ];
        customers = new ArrayList<Customer>();
        numOfEmployees = 0;
        packageNo = 0;
        posX = x;
        posY = y;
    }

    // Methods
    /**
     * @return is x position of the company.
     */
    public int getX() {
        return posX;
    }

    /**
     * @return is y position of the company.
     */
    public int getY() {
        return posY;
    }

    /**
     * @param x is x position of the company.
     * @param y is y position of the company.
     */
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }

    /**
     * Adds a new employee to the company.
     * @param candidate is the new employee candidate.
     * @return indicates whether adding the employee was succesful.
     */
    public boolean addEmployee( Employee candidate ) {
        if ( numOfEmployees >= EMPLOYEE_CAPACITY ) {
            return false;
        }
        employees[numOfEmployees] = candidate;
        numOfEmployees++;
        return true;
    }

    /**
     * Adds a customer to the company
     * @param customer is the customer to be added.
     */
    public void addCustomer( Customer customer ) {
        customers.add( customer );
    }

    /**
     * Fires the employee at the specified index.
     * @param employeeIndex is the index number.
     * @return indicates if the termination occured correctly.
     */
    public boolean terminateContract( int employeeIndex ) {
        if ( employeeIndex >= EMPLOYEE_CAPACITY ) {
            return false;
        }

        employees[employeeIndex] = null;
        numOfEmployees--;
        for ( int i = employeeIndex; i < EMPLOYEE_CAPACITY - 1; i++ ) {
            employees[i] = employees[i + 1];
        }
        return true;
    }

    /**
     * Creates a new delivery.
     * @param sendItem is the item to be sent.
     * @param sender is the sender customer.
     * @param receiver is the receiver customer.
     * @return indicates if there any available employees.
     */
    public boolean createDeliverable( Item sendItem, Customer sender, Customer receiver ) {
        for ( int i = 0; i < numOfEmployees; i++ ) {
            if ( employees[i] != null ) {
                if ( employees[i].getAvailability() ) {
                    employees[i].addJob( sendItem, sender, receiver, packageNo );
                    packageNo++;
                    return true;
                }
            }
        }
        return false;   
    }

    /**
     * Delivers all the packages all the employees have.
     */
    public void deliverPackages() {
        for ( int i = 0; i < numOfEmployees; i++ ) {
            if ( employees[i] != null ) {
                employees[i].deliverPackages();
                packageNo = 0;
            }
        }
        customers.clear();
    }

    @Override
    /**
     * Returns the string representaion of the company.
     * @return is the company info.
     */
    public String toString() {
        String result;

        result = "Employees: \n";
        for ( int i = 0; i < numOfEmployees; i++ ) {
            if ( employees[i] != null ) {
                result += employees[i].toString() + "\n\n";
            }
        }

        result += "\nAll deliviries: \n";
        for ( int i = 0; i < numOfEmployees; i++ ) {
            for ( int j = 0; j < employees[i].currentJobs; j++ ) {
                result += employees[i].deliveries[j] + "\n\n";
            }
        }

        return result;
    }

}
