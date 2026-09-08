  package TaxiBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class View {

	public static void displayBooking() throws SQLException{
		
		Connection con = DBConnection.getConnection();
		
		String query = "SELECT * FROM booking";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
        System.out.println("\n--- Booking History ---");
        System.out.printf("%-12s %-14s %-10s %-12s %-12s %-13s %-10s %-8s\n",
                "Booking ID", "Customer ID", "Taxi ID", "Pickup", "Drop", "Pickup Time", "Drop", "Amount");

        boolean hasBookings = false;

        while (rs.next()) {
            hasBookings = true;

            int bookingId = rs.getInt("booking_id");
            int customerId = rs.getInt("customer_id");
            int taxiId = rs.getInt("taxi_id");
            String pickup = rs.getString("pickup_point");
            String drop = rs.getString("drop_point");
            int pickupTime = rs.getInt("pickup_time");
            int dropTime = rs.getInt("drop_time");
            double amount = rs.getDouble("amount");

            System.out.printf("%-12d %-14d %-10d %-12s %-12s %-13d %-10d ₹%-7.2f\n",
                    bookingId, customerId, taxiId, pickup, drop, pickupTime, dropTime, amount);
        }

        if (!hasBookings) {
            System.out.println("No bookings found.");
        }
		
		
	}

	

}
