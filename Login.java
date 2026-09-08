package TaxiBooking;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	
	static Scanner sc = new Scanner(System.in);

	public static int handleLoginMenu() throws SQLException {
		
		int customerId = -1;
		
		 while (true) {
			 
	            System.out.println("\n--- CUSTOMER LOGIN MENU ---");
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();
	            
	            if(choice == 1) {
	            	customerId = register();
	            	
	            	if(customerId != -1) {
	            		System.out.println("Register Succesfully.Your cutomerId is : " + customerId);
	            		break;
	            	}
	            }
	            else if(choice == 2) {
	            	
	            	customerId = login();
	            	 if (customerId != -1) {
	            		 
	                     System.out.println("login Successfully! Your Customer ID: " + customerId);
	                     break;
	                 }
	            
	            else {
	            	System.out.println("Invalid phone/password. Try again.");
	            }
	            }
	            else {
	            	break;
	            }
		 }
		 
		 return customerId;
	}

	private static int login() throws SQLException {

		  System.out.print("Enter Phone: ");
	        String phone = sc.nextLine();

	        System.out.print("Enter Password: ");
	        String password = sc.nextLine();

	        return LoginDAO.loginCustomer(phone, password);
		
	}

	private static int register() throws SQLException {
		
		System.out.println("Enter Name ");
		String name = sc.nextLine();
		
		System.out.println("Enter Phone Number ");
		String phone = sc.nextLine();
		
		if(!isValidPhoneNo(phone)) {
			
			System.out.println("Invalid Phone Number. must be 10 digit starting 6/7/8/9 ");
			return -1;
		}
		
		System.out.println("Enter Password ");
		String password = sc.nextLine();
		
		if(!validPassword(password)) {
			
			System.out.println("Password must be atleast 6 Characters with letters and Numbers ");
			return -1;
		}
		
		return LoginDAO.registerCustomer(name,phone,password);
	}

	
	
	
	private static boolean validPassword(String password) {
		
		return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
	
	}

	private static boolean isValidPhoneNo(String phone) {
		
		return phone.matches("[6-9][0-9]{9}");
	}

}
