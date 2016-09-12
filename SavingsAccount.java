//package account;
public class SavingsAccount extends Account {
	
	private double interestRate;
	
	public SavingsAccount(String ownerName, double balance, double interestRate) {
		super(ownerName, balance);
		if (interestRate < 0) {
			throw new IllegalArgumentException("Interest rate cannot be negative.");
		}
		else {
		this.interestRate = interestRate;
		}
	}
	
	public void applyInterest(double years) {
		if (years < 0) 
		{
			throw new IllegalArgumentException("Years cannot be negative.");
		}
		else {
		
		/* When interest is compounded annually; 
		that is, when interest is only applied at the end of a full year, 
		only the amount of full years that have passed matters in calculation.
		Fractions of years do not affect the balance. */
		
		Double Years=years;
		String[] split = Years.toString().split("\\.");
		int wholeYears = Integer.parseInt(split[0]); 
		
		/* The balance is rounded to two decimal places in the getBalance() function,
		but the possibility for partial cents exists with the calculation below. 
		Banks do have to keep track of partial cent values; so it's useful to allow
		for them to exist with the actual balance value, but to round it off when
		showing balances to customers. */ 
		
		this.balance = this.balance*Math.pow((1+this.interestRate), wholeYears);
		}
	}
}
