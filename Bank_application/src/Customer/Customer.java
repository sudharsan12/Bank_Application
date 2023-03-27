package Customer;

public class Customer {

	int customerId;
	String name;
	public double balance;
	String password;
	long accoundId;
	public Customer(int customerId, String name, double balance, String password,long accountId) {
		this.customerId = customerId;
		this.name = name;
		this.balance = balance;
		this.password = password;
		this.accoundId=accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAccoundId() {
		return accoundId;
	}
	public void setAccoundId(long accoundId) {
		this.accoundId = accoundId;
	}
	
	
	
	
	
}


