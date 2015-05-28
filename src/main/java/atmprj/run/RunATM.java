package atmprj.run;

import atmprj.ATM;
import atmprj.Account;
import atmprj.BankAccounts;
import atmprj.Card;
import atmprj.Customer;

public class RunATM {
	
	public static void main(String[] args) {
		
		// Create a new account object for a customer named 'Mr. Brown' with 50000 Rs. in his account.		
		Account account = new Account(9876, "Mr. Brown", 50000.00);
				
		// Make an ATM card object for the new customer				
		Card cust_ATMCard = new Card(account.getPin(), account.getStrip_Number());
		
		// Make a Customer object and assign the card created
	//	Customer new_customer = new Customer(cust_ATMCard);
		
		// Creating BankAccount object which will add that account 		
		BankAccounts newBankAccounts = new BankAccounts("MoneyBank");
				
		//Adding customer account into BankAccounts Object
		newBankAccounts.addBankAccount(account);
		
		//creating ATM related to that bank		
		ATM atm = new ATM(newBankAccounts);
		
		atm.isStripReadable(cust_ATMCard);
		
		//ATM card strip will have a number that will be readable by the ATM machine
		atm.settingATMTransactionValues(cust_ATMCard);
		
		//asking for pin value				
		if (atm.insertPIN(cust_ATMCard)){
			// Asks the customer how much money they want to withdrawal
			//though the problem suggested to have only one transaction and then quit the session but i thought may be it would be better to have a running session for the atmuser.
			//that's why I am using 'do-while'loop, taking it out will run this only one time. 
			do{
				atm.choiceOfTransactionType();			
				atm.getTransactionInfo();
				System.out.println("\n\n");
			}while(atm.isSessionRunning());
			
			atm.closeScanner();
			account =null;
			cust_ATMCard=null;
			newBankAccounts=null;
			atm=null;
		
			
		}
		else {
			System.out.println("Thank you for using MoneyBank ATM!!!");			
		}		
	}

}
