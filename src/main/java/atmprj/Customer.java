package atmprj;

public class Customer {
	
	private Card cust_ATMCard;

	// Replaces public Card insertATMCard()

	public Customer(Card card){
		
		cust_ATMCard = card; 
		
	}
	
	public Card getCustomerATMCard() { return cust_ATMCard; }

}
