package atmprj;

import java.util.Scanner;

public class ATM {
	
	private ATMTransaction transaction = null;
	private BankAccounts bankAccount = null;
	
	private boolean sessionRunning = false;
	private int numberEntered=0;
	
	
	public boolean isSessionRunning() {
		return sessionRunning;
	}

	public void setSessionRunning(boolean sessionRunning) {
		this.sessionRunning = sessionRunning;
	}

	// Used to get input from the customer	
	static Scanner scanner = new Scanner(System.in);
	
	//constructor
	public ATM(BankAccounts bankAccount){		
		this.bankAccount = bankAccount;
		
	}
	
	public boolean isStripReadable(Card card){
		
		// Returns the number of digits in stripNumber
		
		if (card.getStrip_Number() > 0){
			transaction = new ATMTransaction(card.getStrip_Number());
			return true;
		}		
		else {			
			return false;	
		}
		
	}
	
	//this is to check whether an 'ATMUser' has entered 4 digits as PIN
	public boolean checkPINdigits(int pin){
		int numberOfDigitsInPIN = (int) (Math.log10(pin)+1);
		if(numberOfDigitsInPIN != 4){			
			System.out.println("You have to enter 4 digits for a PIN");				
			return false;			
		}
		return true;
	}
	
	public boolean insertPIN(Card card){		
		System.out.println("Please enter your PIN number:");		
		
		if (scanner.hasNextInt()){
			int pin = scanner.nextInt();
			
			if (checkPINdigits(pin)) {
				transaction.setPIN(pin);
				
				if(!bankAccount.verifyThePIN(transaction)){
					System.out.println("Your PIN doesn't match with our records, please enter the correct one!!!");
					return false;
				}
				//setting session running as true
				setSessionRunning(true);
			}
			return true;
		} 
		
		return false;
		
	}
	
	
	
	public void settingATMTransactionValues(Card card){
		transaction.setStripNumber(card.getStrip_Number());
		transaction.setDidTheCardVerify(true); 
	}
	
	//this is to get whether users wants to deposit or withdraw money from his account
	public void choiceOfTransactionType(){
		scanner.nextLine();
		System.out.println("Please specify what kind of transaction you would like to do; Enter 'D' or 'd' for 'Deposit' OR 'w' or 'W' to withdraw money from your account  ::");
		
		if(scanner.hasNext()){
			String trType = scanner.nextLine();
			transaction.updateTransactionTime();
			
			if(trType.matches("D")||trType.matches("d")){
				transaction.setTransactionType(TransactionType.DEPOSIT);
				
			}
			else if (trType.matches("W")||trType.matches("w")) {
				transaction.setTransactionType(TransactionType.WITHDRAW);
			}
			else {
				transaction.setTransactionType(TransactionType.NULL);
			}
			callTransactionMethod();
		}		
	}
	
	public void makeDepositTransaction(){
		transaction.setDeposit_Amt(numberEntered);
		bankAccount.makeDepositAmt(transaction);
	}
	
	public void makeWithdrawalTransaction(){
		transaction.setWithdrawalAmt(numberEntered);
		bankAccount.requestWithdrawalAmt(transaction);
	}
	
	
	private void callTransactionMethod(){
		switch(transaction.getTransactionType()){
			case DEPOSIT:
				getAmountToDeposit();
				makeDepositTransaction();
				break;
			case WITHDRAW:
				amountToWithdrawal();
				makeWithdrawalTransaction();
				break;
			case NULL:
				setSessionRunning(false);
				System.out.println("thank you for your business!!! please start your session again");
				break;
			default:
				System.out.println("Please enter a single lettter (D:Deposit or W:Withdrawal) to select your transaction type");
				break;
		
		}
	}
	
	private void getAmountToDeposit() {
		System.out.println("Please enter the amount you want to deposit:");
		if (scanner.hasNextInt()){
			numberEntered = scanner.nextInt();
		} else {
			System.out.println("You Entered an Invalid Amount");
		}		
	}

	private void amountToWithdrawal(){

		System.out.println("Please enter the amount you want to withdrawal ");

		if (scanner.hasNextInt()){
			numberEntered = scanner.nextInt();
		} else {
			System.out.println("You Entered an Invalid Amount");
		}

	}
	
	public void getTransactionInfo(){
		
		System.out.println("\nThank you " + transaction.getCustomer_Name() + " for using the 'MoneyBank' ATM");
		
		/*System.out.println("Date / Time of your last transaction: " + transaction.getCurrentDateTime());
		System.out.println("Transaction Details::");*/
		
		switch(transaction.getTransactionType()){
			case DEPOSIT:
				System.out.print("Deposited Rs." + transaction.getDeposit_Amt() + " into your account.");
				printCurrentBalance();
				break;
			case WITHDRAW:
				System.out.print("Withdraw Rs." + transaction.getWithdrawalAmt() + " from your account.");
				printCurrentBalance();
				break;
			default:
				break;			
		
		}	
	}
	
	private void printCurrentBalance(){
		System.out.println("Your current balance is :"+bankAccount.getAccountbalance());
	}
	public void closeScanner(){
		scanner.close();
	}
	
}
