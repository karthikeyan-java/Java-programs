package TaxiBooking;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		int customerId = Login.handleLoginMenu();
		
		if(customerId == -1) {
			
			System.err.println("Exiting...");
			return;
		}
	
		System.out.println("\nWelcome Customer ID: " + customerId);
		
		
		while(true) {

			    System.out.println("\n--- Call Taxi Booking System ---");
	            System.out.println("1. View Taxi");
	            System.out.println("2. Book Taxi");
	            System.out.println("3. View Bookings");
	            System.out.println("4. Exit");
	            System.out.print("Choose option: ");

	            int choice = sc.nextInt();
	            
	            switch(choice) {
	            
	            case 1:
	            	 Taxi.displayTaxi();
	            	 break;
	            case 2:
	            	Booking.addBooking();
	            	break;
	            case 3:
	            	 View.displayBooking();
	            	 break;
	            case 4:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
	            }
		}
		
	}

}
