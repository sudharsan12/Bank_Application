package Customer;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

import bank.Bank;

public class CustomerFileHandler {
	
	public static CustomerFileHandler handler;
	
	public static CustomerFileHandler getInstance()
	{
		if(handler==null)
			handler= new CustomerFileHandler();
		
		return handler;
	}
	 
	
	private static final String filename="bank_txt.db";
	
	public void initilize() throws IOException
	{
		
		File file=new File(filename);
		
		BufferedReader reader=new BufferedReader(new FileReader(file));
		
		String  customerInfo=reader.readLine();
		
		if(customerInfo==null)
			return;
		
		do {			
			Customer customerClass=castStringToCustomer(customerInfo);
			Bank.customerList.add(customerClass);
			Bank.customerMap.put(customerClass.customerId,customerClass);
			customerInfo=reader.readLine();
			
		}while(customerInfo!=null);
		
		reader.close();

		Bank.position=Bank.customerList.size()-1;
		Bank.refCustomerId=Bank.customerList.get(Bank.customerList.size()-1).customerId;
		Bank.recAccountNo=Bank.customerList.get(Bank.customerList.size()-1).accoundId;
	}
	
	private Customer castStringToCustomer(String customerInfo)
	{
		
		String[] trimedInfo=customerInfo.split(" ");
		
		Customer customer=new Customer(Integer.parseInt(trimedInfo[0]),trimedInfo[2],Double.parseDouble(trimedInfo[3]),trimedInfo[4],Long.parseLong(trimedInfo[1]));
		
		return customer;
		
	}
	
	public void addCustomerToFile(Customer customer)
	{
		File file=new File(filename);
		
		FileWriter writer = null;
		try {
			writer=new FileWriter(file,true);
			
			writer.write(customer.toString()+"\n");			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			if(writer!=null)
			{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			}
		}
		
	}
	
	
	public void finalizeFile()
	{
		File file=new File(filename);
		
		FileWriter writer=null;
		
		try {
			writer=new FileWriter(file);
		Set keySet=Bank.customerMap.keySet();	
		
		Iterator iterator=keySet.iterator();
	
		while(iterator.hasNext()) {
			int customerId=(int) iterator.next();
			Customer customer=Bank.customerMap.get(customerId);
		
				writer.write(customer.toString()+"\n");
			}
		}catch (IOException e) {
				
				e.printStackTrace();
			}finally
		{
			if(writer!=null)
			{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			}
		}
			
	
	}
		

}
