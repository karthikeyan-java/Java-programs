package TaxiBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Booking {

	public static void addBooking() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Id ");
		int customerId = sc.nextInt();
		
		System.out.println("Enter pickup Point ");
		char pickupPoint = sc.next().toUpperCase().charAt(0);
		
		System.out.println("Enter Drop Point ");
		char dropPoint = sc.next().toUpperCase().charAt(0);
		
		System.out.println("Enter Pickup Time ");
		int pickupTime = sc.nextInt();
		
		int pickup = pickupPoint - 'A' + 1;
        int drop = dropPoint - 'A' + 1;
        
		Connection con = DBConnection.getConnection();
		
		String query = "SELECT * FROM taxi";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Taxi> availableTaxis = new ArrayList<>();
		
		while(rs.next()) {
			
			int taxiId = rs.getInt("Taxi_id");
			char currentPoint = rs.getString("current_spot").charAt(0);
			int freeTime = rs.getInt("free_time");
			double earnings = rs.getDouble("total_earnings");
			
			 int taxiLoc = currentPoint - 'A' + 1;
			int travelTime = Math.abs(taxiLoc - pickup);
			int reachTime = travelTime + freeTime;
			
			if(reachTime <= pickupTime) {
				
				availableTaxis.add(new Taxi(taxiId,currentPoint,freeTime,earnings));	
			}
		}
		
			if(availableTaxis.isEmpty()) {
				
				System.out.println("No Taxi is alloted ");
				return;

			}
	
			availableTaxis.sort(Comparator.comparingDouble(Taxi :: gettotalEarnings)
					.thenComparingInt(t -> Math.abs((t.getLocation() - 'A' + 1) - pickup))
					

					
					
					);
			
			Taxi chosenTaxi = availableTaxis.get(0);
			
			
			int distance = Math.abs(drop - pickup) * 15;
			int rideTime = Math.abs(drop - pickup);
			int dropTime = pickupTime + rideTime;
		
			int fare = 100 + ((distance - 5) * 10); // fixed ₹100 for first 5 km, ₹10/km after

			String insertBooking = "INSERT INTO booking (customer_id, taxi_id, pickup_point, drop_point, pickup_time, drop_time, amount) " +
                    "VALUES (" + customerId + ", " + chosenTaxi.getTaxiId() + ", '" + pickupPoint + "', '" + dropPoint + "', " +
                    pickupTime + ", " + dropTime + ", " + fare + ")";
					
			st.executeUpdate(insertBooking);
					
			  double updatedEarnings = chosenTaxi.gettotalEarnings() + fare;
			  
			     
		        String updateTaxi = "UPDATE taxi SET current_spot = '" + dropPoint + "', free_time = " + dropTime +
		                            ", total_earnings = " + updatedEarnings + " WHERE taxi_id = " + chosenTaxi.getTaxiId();
		      
		        st.executeUpdate(updateTaxi);
		        
		        System.out.println(chosenTaxi.taxi_id +" Booked...");
		        

	}
	
	

}
