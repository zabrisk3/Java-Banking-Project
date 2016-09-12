public class CheckingAccount extends Account {
	
	public CheckingAccount(String ownerName, double balance) {
		super(ownerName, balance);
	}

	public void withdraw(double amount) {
		if (getNumberOfDecimals(amount) > 2) {
			throw new IllegalArgumentException("Cannot withdraw partial cents.");
		}
		else if (amount > this.balance) {
			throw new IllegalArgumentException("Cannot withdraw more than the balance.");
		}
		else if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount.");
		}
		else {
		this.balance -= amount;
		}
	}
}
