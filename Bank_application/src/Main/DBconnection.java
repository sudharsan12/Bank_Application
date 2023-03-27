package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection
{
	
	private static String url="jdbc:mysql://localhost:3306/BankServer";
	
	private static String user="root";
	
	private static String passwrd="Sudharsan1998";
	
	
	public static  Connection getConnection() throws SQLException
	{
		Connection connection= DriverManager.getConnection(url,user,passwrd);	
		return connection;
	}
	
		
	
}