/*
These files were run using Eclipse, so
the CheckingAccount and SavingsAccount  
classes did not need to be directly imported. 
the import commands are left here, commented out, 
in case they are desired for those who examine 
this code. 

package com.acumensolutions.bank;
import account.CheckingAccount;
import account.SavingsAccount
*/
public class BankTest {

	public static void main(String[] args) {
		System.out.println("Welcome to Acumen Bank!");
		System.out.println();

		CheckingAccount michaelsAccount = new CheckingAccount("Michael", 5000);
		CheckingAccount gobsAccount = new CheckingAccount("Gob", 2000);

		System.out.println("Open Accounts:");
		System.out.println();
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		System.out.println();
		System.out.println("Making transfer of $1000...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			return;
		}

		michaelsAccount.transfer(gobsAccount, 1000);

		System.out.println("Updated Account Details:");
		System.out.println();
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		// sample code for savings account implementation
		
		// Initialize new savings account with initial balance of $30,000 and 0.89% interest
		SavingsAccount acesSavingsAccount = new SavingsAccount("Ace", 30000, .0089);
		SavingsAccount garysSavingsAccount = new SavingsAccount("Gary", 10000, .0056);
		
		acesSavingsAccount.transfer(garysSavingsAccount, 5000);
		
		// apply 2 years of interest to the savings accounts
		acesSavingsAccount.applyInterest(2);
		garysSavingsAccount.applyInterest(2);
		
		// Print account balances for Ace and Gary
		printAccountDetails(acesSavingsAccount);
		printAccountDetails(garysSavingsAccount);
	
	}

	private static void printAccountDetails(Account account) {
		System.out.format("Account for %s:\r\n", account.getOwnerName());
		System.out.format("Balance: $%.2f\r\n", account.getBalance());
		
	}
}