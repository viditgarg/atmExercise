package atmprj;


public class BankAccounts {
	
	private String bank_Name=null;
	private Account account=null;
	
	
	public double getAccountbalance() {
		return account.getAccount_Balance();
	}

	public BankAccounts (String new_BankName) {
		this.setBank_Name(new_BankName);
	}
	
	public void addBankAccount(Account newAccount){		
		this.account = newAccount; 		
	}
	
	// Verifies that a card with the strip number is in a bank

	public Boolean verifyTheStripNumber(Card card){

		Boolean verifyCard = false;

		if(account.getStrip_Number() == card.getStrip_Number()){
			verifyCard = true;
		}

		return verifyCard;
	}
	
	// Verifies that a card with the strip number and PIN is in a bank
	
		public Boolean verifyThePIN(ATMTransaction transaction){
			
			Boolean cardVerification = false;
			
			if(transaction.getDidCardVerify()){
				
				if((account.getPin() == transaction.getPIN()) && (account.getStrip_Number() == transaction.getStrip_Number())){					
					cardVerification = true;					
					transaction.setCustomer_Name(account.getCustomer_Name());									
				}				
			}			
			return cardVerification;			
		}
		
		public boolean requestWithdrawalAmt(ATMTransaction transaction){
				
			if(account.getAccount_Number() == transaction.getAccountNumberUsed()){					
				if(account.getAccount_Balance() >= transaction.getWithdrawalAmt()){						
					account.setAccount_Balance( (account.getAccount_Balance()-transaction.getWithdrawalAmt()));
					return true;
				} else {						
					System.out.println("Your account balance is Rs. "+account.getAccount_Balance()+", You can't withdrawal that much money");
					transaction.setTransactionType(TransactionType.NULL);
					return false;
				}					
			}
			return false;
		}
		
		public void makeDepositAmt(ATMTransaction transaction){
			
			if(account.getAccount_Number() == transaction.getAccountNumberUsed()){
				
					double newAcctBalance = account.getAccount_Balance() + transaction.getDeposit_Amt();
						
					account.setAccount_Balance(newAcctBalance);										
			}				
		}

		public String getBank_Name() {
			return bank_Name;
		}

		public void setBank_Name(String bank_Name) {
			this.bank_Name = bank_Name;
		}
	
	
}
