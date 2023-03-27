package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Main.DBconnection;

public class CustomerDAO {

	String query="insert into CustomerTable values (?,?,?,?)";
	
	
	public void insertCustomer(Customer customer) throws SQLException
	{
		Connection connec=DBconnection.getConnection();
		PreparedStatement prestmnt=connec.prepareStatement(query);
		
		prestmnt.setInt(1, customer.getCustomerId());
		prestmnt.setLong(2, customer.getAccoundId());
		prestmnt.setString(3, customer.getName());
		prestmnt.setString(4, customer.getPassword());
		prestmnt.setDouble(5, customer.getBalance());
		prestmnt.executeUpdate();
	}
	
}
