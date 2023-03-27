package Transaction;

public class Transaction {
	
	public   int transactionId;
	public String type;
	double amount;
	double balance;
	
	public Transaction(int transactionId,String type, double amount, double balance) {
		this.transactionId=transactionId;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return transactionId +"\t"+type + "\t" + amount + "\t" + balance + "\n";
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
