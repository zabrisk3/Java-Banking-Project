
//package account;
public class Account {
	protected String ownerName;
	protected double balance;

	public Account(String ownerName, double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("Balance cannot be negative.");
		}
		else if (getNumberOfDecimals(balance) > 2) {
			throw new IllegalArgumentException("Cannot provide partial cents.");
		}
		else{
		this.ownerName = ownerName;
		this.balance = balance;
		}	
	}
	
	/* When dealing with money, it is customary not to be
	 able to transfer, withdraw, or deposit partial cents,
	 so it is important to check this with possible
	 monetary values. */
	
	protected int getNumberOfDecimals(double amount) {
		Double Amount = amount;
		String[] splitter = Amount.toString().split("\\.");
		return splitter[1].length();
	}
	
	public void transfer(Account destinationAccount, double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot transfer a negative amount.");
		}
		else if (amount > this.balance) {
			throw new IllegalArgumentException("Transfer amount cannot be more than balance.");
		}
		else if (getNumberOfDecimals(amount) > 2) {
			throw new IllegalArgumentException("Cannot transfer partial cents.");
		}
		else {
			destinationAccount.deposit(amount);
			this.balance -= amount;
		}
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount.");
		}
		else if (getNumberOfDecimals(amount) > 2) {
			throw new IllegalArgumentException("Cannot deposit partial cents.");
		}
		else {
		this.balance += amount; 
		}
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public double getBalance() {
		return Math.round(this.balance*100.0)/100.0;
	}
}