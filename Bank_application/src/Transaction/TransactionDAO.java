package Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.DBconnection;

public class TransactionDAO {
	
	static String query="insert into TransactionTable values(?,?,?,?,?)";
	


	public static void insertCustomer(int customerId,Transaction transaction) throws SQLException
	{
		Connection connec=DBconnection.getConnection();
		PreparedStatement prestmnt=connec.prepareStatement(query);
		
		prestmnt.setInt(1,transaction.getTransactionId());
		prestmnt.setInt(2, customerId);
		prestmnt.setString(3, transaction.getType());
		prestmnt.setDouble(4, transaction.getAmount());
		prestmnt.setDouble(5, transaction.getBalance());
		prestmnt.executeUpdate();
	}
	
	
	public static int getTransactionId(int customerId)
	{
		
		String query="select max(transactionId) from TransactionTable";
		
		return 0;
	}
	
}
