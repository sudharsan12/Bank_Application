package bank;

import Customer.Customer;
import Transaction.Transaction;
import Transaction.TransactionHandler;

public class AccountActionHandler {
	
	public void deposit(int customerId,double amount)
	{
		if(amount<0)
			return;
		Customer customer=Bank.customerMap.get(customerId);
		customer.balance+=amount;
		
		Bank.customerMap.put(customerId, customer);
	
		TransactionHandler handler =new TransactionHandler();
	   int lastTransId=handler.getLastTransactionId(customerId);   
	   Transaction trasaction=new Transaction(lastTransId++, "Deposit", amount,customer.balance);
	   
	}
	
	public boolean withDraw(int customerId,double amount)
	{
		Customer customer=Bank.customerMap.get(customerId);
		double balance =customer.balance-amount;
		
		if(balance>=1000)
		{
			customer.balance-=amount;
			Bank.customerMap.put(customerId, customer);
			

			TransactionHandler handler =new TransactionHandler();
		   int lastTransId=handler.getLastTransactionId(customerId);
		   
		   Transaction trasaction=new Transaction(lastTransId++, "With Draw", amount,customer.balance);
		
			return true;
		}
		System.out.println("Insufficent Balance");
		return false;
	}
	
	public boolean transfer(int fromCustomerId,int toCustomerId,double amount)
	{
		Customer tocustomer =Bank.customerMap.get(toCustomerId);
		
		if(tocustomer==null)
		{
			System.out.println("customerID is not found");
			return false; 
		}
		
		Customer fromcustomer=Bank.customerMap.get(fromCustomerId);
	
		boolean isSuccess=withDraw(fromCustomerId, amount);
		
		if(isSuccess)
		{
			deposit(toCustomerId, amount);
			return true;
		}

	return false;
     }
	
	
	
}