package Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionHandler {
	
	public void writeTransaction(int customerId,Transaction transaction) throws SQLException
	{
		TransactionDAO.insertCustomer(customerId, transaction);	
	}
	
	public int getLastTransactionId(int customerId)
	{
      
	 return 0;
	}
	
	private Transaction castString(String str)
	{
		String[] info=str.split("\t");
		
		Transaction transaction=new Transaction(Integer.parseInt(info[0]), info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]));
		
		return transaction;
	}

}
