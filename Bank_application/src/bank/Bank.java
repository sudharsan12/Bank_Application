package bank;
 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Customer.Customer;
public class Bank {

	
	public static List<Customer> customerList=new ArrayList<Customer>();
	public static HashMap<Integer,Customer>customerMap=new HashMap<Integer,Customer>();
	
	public static int refCustomerId;
	public static long recAccountNo;
	public static int position;
	public static final double INITIAL_BALANCE=1000;
}
