package TaxiBooking;

import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Taxi {
	
	int taxi_id;
	char current_spot;
	int free_time;
	double total_earnings;
	
	public Taxi(int taxi_id,char current_spot,int free_Time,double total_earnings) {
		
		this.taxi_id = taxi_id;
		this.current_spot = current_spot;
		this.free_time = free_Time;
		this.total_earnings = total_earnings;
		
	}
	
	public double gettotalEarnings() {
		return total_earnings;
	}
	
	public char getLocation() {
		return current_spot;
	}

	public static void displayTaxi() throws SQLException {
		
		
		Connection con = DBConnection.getConnection();
		
		String query = "SELECT * FROM taxi";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		 System.out.println("\n--- List of Taxis ---");
	        System.out.printf("%-10s %-20s %-15s %-15s\n", "Taxi_ID", "Current_Spot", "Free_Time","Total_Earnings");
	        System.out.println("---------------------------------------------------------------");
	
	        while (rs.next()) {

	            int id = rs.getInt("taxi_id");
	            String s = rs.getString("current_spot");	            
	            int t = rs.getInt("free_time");
	            double e = rs.getDouble("total_earnings");
	
	            System.out.printf("%-10d %-20s %-15d %-15.2f\n", id,s,t,e);
	        }
	        
	        con.close();
		
	}

	public int getTaxiId() {

		return taxi_id;
	}

	

}
