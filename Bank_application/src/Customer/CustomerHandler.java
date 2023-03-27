package Customer;

import java.sql.SQLException;
import java.util.Scanner;

import Transaction.Transaction;
import Transaction.TransactionHandler;
import bank.Bank;


public class CustomerHandler {
	
	public void addCustomer()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=input.nextLine();
		System.out.println("Enter the Password");
		String Password=input.nextLine();
		
		System.out.println("re-Enter the Password");
		String re_Password=input.nextLine();
		
		if(!(Password.equals(re_Password)&&isvalidPassword(re_Password)))
		{
			System.out.println("Add customer is failed");
			return;
		}
		
		Bank.refCustomerId++;
		Bank.recAccountNo++;
		Customer customer=new Customer(Bank.refCustomerId, name,Bank.INITIAL_BALANCE, getEncryptedPassword(Password), Bank.recAccountNo);
		Bank.customerList.add(customer);
		
		CustomerFileHandler.getInstance().addCustomerToFile(customer); 
		
		
	logTransaction(Bank.refCustomerId);
	
	}
		private void logTransaction(int customerId)
		{
			Transaction trans=new Transaction(1,"Opening", 10000,10000);
	
		    TransactionHandler handler=new TransactionHandler();
		    
		    System.out.println("inside of log transaction");
		    try {
				handler.writeTransaction(customerId, trans);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
	   } 
	
	
	private boolean isvalidPassword(String re_Password) {
		
		int Upper_count=0;
		int Lower_count=0;
		int Numbers_count=0;
		int n=re_Password.length();
		
		if(n<6)
		return false;
		
		for(int i=0;i<n;i++)
		{
			char c=re_Password.charAt(i);
			
			if(c>='A'&& c<='Z')
				Upper_count++;
			if(c>='a'&& c<='z')
				Lower_count++;
		    if(c>='0'&& c<='9')
		    	Numbers_count++;
		}
		
		
		if(Upper_count>=2 && Lower_count>=2 && Numbers_count>=2)
			return true;
		
		return false;
	}

	private String getEncryptedPassword(String Password)
	{
		String Encrypt="";
	
		for(int i=0;i<Password.length();i++)
		{
			char c=Password.charAt(i);
			
			if(c=='Z'||c=='z'||c=='9')
			{
				if(c=='9')
					c='0';
				else
					c-=25;
			}
			else
			{
				c+=1;
			}
			
			Encrypt+=c;
		}
		
		
		return Encrypt;
		
	}
	
	public boolean authenticateCustomer(int customerId,String Password)
	{
	String Encrypt=getEncryptedPassword(Password);
	
	Customer c=Bank.customerMap.get(customerId);
	
	if(c==null)
	{
		System.out.println("Invalid customer id");
		return false;
	}
	if(Encrypt.equals(c.password))
	{
		return true;
	}
	return false;
	}

}
