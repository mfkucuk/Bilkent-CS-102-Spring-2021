import java.util.*;

/**
 * Testing class for company and all the other subclasses and related classes.
 * @author Mehmet Feyyaz Kucuk
 * @version 03.09.2021
 */
public class CompanyTester {
    public static void main(String[] args) throws Exception {
        
        // Variables
        Scanner scan;
        Company company;
        int option;
        String itemContent;
        double itemWeight;
        Customer sender;
        Customer receiver;
        Employee emp1;
        Employee emp2;

        // Program Code
        // Initalize variables
        scan = new Scanner( System.in );
        company = new Company( 0, 0 );
        emp1 = new Employee( (int) (Math.random() * 10000), "Feyyaz");
        emp2 = new Employee( (int) (Math.random() * 10000), "Tarik" );

        // Initally there will be two employees.
        company.addEmployee( emp1 );
        company.addEmployee( emp2 );

        do {
            System.out.println( "1. Send item" );
            System.out.println( "2. Deliver packages" );
            System.out.println( "3. Hire employee" );
            System.out.println( "4. Fire employee" );
            System.out.println( "5. Print company info" );
            System.out.println( "6. Quit" );

            System.out.print( "Choose: " );
            option = scan.nextInt();

            if ( option == 1 ) {

                // Get delivery info.
                scan.nextLine();
                System.out.print( "What is your name: " );
                sender = new Customer( scan.nextLine() );
                System.out.print( "Who do you want to send this delivery to: " );
                receiver = new Customer( scan.nextLine() );
                System.out.print( "How much does your delivery weight: " );
                itemWeight = scan.nextDouble();
                scan.nextLine();
                System.out.print( "What is the content of your delivery: " );
                itemContent = scan.nextLine();

                // Add both sender and the receiver.
                company.addCustomer( sender );
                company.addCustomer( receiver );
                
                // Create delivery.
                if ( sender.sendItem( company, new Item( itemWeight, itemContent ), receiver ) ) {
                    System.out.println( "Your delivery has been taken." );
                }
                else {
                    System.out.println( "There are no available employees at the moment." );
                }
            }
            else if ( option == 2 ) {
                company.deliverPackages();
            }
            else if ( option == 3 ) {
                scan.nextLine();
                System.out.print( "Enter the name of the employee: " );
                
                if ( company.addEmployee( new Employee( (int) (Math.random() * 1000), scan.nextLine() ) ) ) {
                    System.out.println( "Employee hired." );
                }
                else {
                    System.out.println( "Company is full!" );
                }
            }
            else if ( option == 4 ) {
                System.out.print( "Enter the employee index of who you want to fire: " );
                company.terminateContract( scan.nextInt() );
            }
            else if ( option == 5 ) {
                System.out.println( company );
            }
            else if ( option == 6 ) {
                System.out.println( "Thank you for using our company's app!" );
            }
            else {
                System.out.println( "Error: this is not a valid option!" );
            }

        } while ( option != 6 );


        scan.close();
    }
}
