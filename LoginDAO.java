package TaxiBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public static int registerCustomer(String name, String phone, String password) throws SQLException {
		
		
		Connection con = DBConnection.getConnection();
		
		String query = "INSERT INTO customer(customer_name,phone_no,password) VALUES(?, ?, ?)";
		
		PreparedStatement pst = con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
		
		pst.setString(1, name);
		pst.setString(2, phone);
		pst.setString(3, password);
		
		int row = pst.executeUpdate();
		
		int customerId = -1;
		if(row > 0) {
			
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next())
			customerId = rs.getInt(1);
			
		}
		
		con.close();
		return customerId;
	}

	public static int loginCustomer(String phone, String password) throws SQLException {
		
		Connection con = DBConnection.getConnection();
		
		String query = "SELECT customer_Id FROM customer WHERE phone_no = ? AND password = ?";
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, phone);
		pst.setString(2,password);
		
		ResultSet rs = pst.executeQuery();
		
		int customerId = -1;
		
		if((rs.next())){
			
			customerId = rs.getInt("customer_Id");
		}
		con.close();
		
		return customerId;
	}

}
