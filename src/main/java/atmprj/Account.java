package atmprj;

public class Account {
	
	private int pin;
	private final int strip_Number = 1000011;
	private int account_Number;
	private String customer_Name;
	private double account_Balance;
	
	//constructor to initiate Account object
	public Account(int pin, String customer_Name, double account_Balance){
		
		this.pin = pin;
		this.customer_Name = customer_Name;
		this.account_Balance = account_Balance;	
		this.account_Number = getStrip_Number();
		
	}
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getStrip_Number() {
		return strip_Number;
	}

	public int getAccount_Number() {
		return account_Number;
	}

	public void setAccount_Number(int account_Number) {
		this.account_Number = account_Number;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public double getAccount_Balance() {
		return account_Balance;
	}

	public void setAccount_Balance(double account_Balance) {
		this.account_Balance = account_Balance;
	}

	
	
	
	
	

}
