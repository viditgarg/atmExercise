package atmprj;


//This is to validate the fictional card 

public class Card {
	
	private int pin;
	private int strip_Number;
	
	
	// this is to check whether the strip is valid 
	
	public Card(int strip_Number){
		
		this.strip_Number = strip_Number;
			
	}
	
	
	// this is to check whether the pin and strip numbers are valid
	
	public Card(int pin, int strip_Number){
		
		this.pin = pin;
		this.strip_Number = strip_Number;
		
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


	public void setStrip_Number(int strip_Number) {
		this.strip_Number = strip_Number;
	}
}
