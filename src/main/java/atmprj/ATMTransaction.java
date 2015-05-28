package atmprj;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;


public class ATMTransaction extends Transaction {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date currentDateTime;
	private String customer_Name;
//	private double account_Balance;
	

	private int withdrawal_Amt;
	private int deposit_Amt;
	private int accountNumberUsed;
	private int pin;
	private int strip_Number;
	private int acctToWithdrawalFrom;
	private TransactionType transactionType = TransactionType.NULL;
	
	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	// I decided to add verification that the card is allowed to access the bank accounts
	private boolean didCardVerify = false;
	
	public ATMTransaction(int strip_Number){			
		currentDateTime = new Date();
		this.accountNumberUsed = strip_Number;
		this.strip_Number=strip_Number;
	}
	
	public void updateTransactionTime(){
		currentDateTime = new Date();
	}
	
	// Sets that the card has a valid stripNumber
	
		public void setDidTheCardVerify(boolean cardVerified){
			
			didCardVerify = (cardVerified)?true:false;
			
		}
		
		public boolean getDidCardVerify(){ return didCardVerify; }
	
	public String getCustomer_Name() { return customer_Name; }
	
	public void setCustomer_Name(String customer_Name){		
		this.customer_Name = customer_Name;
		
	}
	
	// returns the current date and time as a String
	public String getCurrentDateTime() { return dateFormat.format(currentDateTime); }
	
	public int getPIN(){ return pin; }
	public void setPIN(int pin){
		
		this.pin = pin;
		
	}
	
	public void setStripNumber(int strip_Number){
		this.strip_Number = strip_Number;		
	}
	
	public int getStrip_Number(){ return strip_Number; }
	
	public int getAcctToWithdrawalFrom(){ return acctToWithdrawalFrom; }
	
	public void setWithdrawalAmt(int withdrawal_Amt){
		
		this.withdrawal_Amt = withdrawal_Amt;
		
	}
	
	public int getWithdrawalAmt(){ return withdrawal_Amt; }
	
	public int getDeposit_Amt() {
		return deposit_Amt;
	}

	public void setDeposit_Amt(int deposit_Amt) {
		this.deposit_Amt = deposit_Amt;
	}

	public int getAccountNumberUsed() { return accountNumberUsed; }
	
}
