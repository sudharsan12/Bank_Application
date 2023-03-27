package Main;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import Customer.CustomerComparator;
import Customer.CustomerFileHandler;
import Customer.CustomerHandler;
import bank.AccountActionHandler;
import bank.Bank;

public class Main {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
	  CustomerFileHandler handler=new CustomerFileHandler();	
	   try {
		   handler.initilize();
	   }catch(IOException e)
	   {
	   e.printStackTrace();
	   }

	   Collections.sort(Bank.customerList,new CustomerComparator());
	printMenu();
	
	handler.finalizeFile();
}

	private static void printMenu() {
		
		CustomerHandler handler1=new CustomerHandler();
		
		System.out.println("please select option \n 1 - Create Account \n 2 - account login \n 3 - Exit ");
		
		try {
			Scanner input=new Scanner(System.in);
		    int option=input.nextInt();
		    
		    switch(option)
		    {
		    case 1:
		    	CustomerHandler newCustomer=new CustomerHandler();
		 	    newCustomer.addCustomer();
		 	    break;
		    case 2:
		    	System.out.println("Enter the customer id");
		    	int customerId=input.nextInt();
		    	System.out.println("Enter the Password");
		    	String Password=input.next();
		    	boolean isSuccess =handler1.authenticateCustomer(customerId,Password);
		    	if(isSuccess)
		    	{
		    		accountLogin(customerId);
		    	}
		    	break;
		    	
		    case 3:
		    	return;
		    	default :
		    		System.out.println("Invalid option");
		    }
		    
		}catch (Exception e) {
			System.out.println("Invalid input");
		}
		
		
	}
	
	
	public static void accountLogin(int customerId){
		
		AccountActionHandler account=new AccountActionHandler();
		
		System.out.println("please select option \n  1 - Deposit \n 2 - with draw \n 3 - Fund transfer"
				+ " 4 - Exit ");
		
		double amount;
		
		try {
		Scanner input =new Scanner(System.in);
		int option=input.nextInt();
		
		switch(option)
		{
		case 1:
			System.out.println("Enter the amount");
			amount=input.nextDouble();
			account.deposit(customerId, amount);
			break;
		case 2:
		    System.out.println("Enter the amount");
		    amount=input.nextDouble();
		    account.withDraw(customerId, amount);
		    break;
		case 3:
			System.out.println("Enter the transfered id");
			int toCustomerId=input.nextInt();
			System.out.println("Enter the amount");
			amount=input.nextDouble();
			account.transfer(customerId, toCustomerId, amount);
			break;
			default:
				break;
		}
			
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
	
}
