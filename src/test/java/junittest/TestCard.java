package junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import atmprj.Account;
import atmprj.Card;

public class TestCard {
	
	private static Account account =null;
	private static Card card=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		System.out.println("------------Now TestAccount tests will run--------\n");
		System.out.println("setting up an account for ATMUser with Rs. 10000 and PIN is 2244");		
		// Create a new account object for a customer named 'ATMUser' with 10000 Rupees in her account. the ATM PIN is 2244		
			account = new Account(2244, "ATMUser", 10000.00);
			
			System.out.println("setting an ATM card object for the new customer ");
			card = new Card(account.getPin(), account.getStrip_Number());
			
	}
	

	/***************************************************************************************************
	 * This section is to test Card object, these are 3 test methods.
	 ***************************************************************************************************/
	
	@Test
	public void testCardObjectCreatedSuccessfully(){
		System.out.println("Testing if Card object is created sucessfully-");
		assertNotNull(card);	
	}
	
	@Test
	public void testCardPINNumber(){
		System.out.println("Testing if PIN number is 2244 associated with Card");
		assertEquals(2244, card.getPin());
	}
	
	@Test
	public void testCard_StripNumber(){
		System.out.println("Testing if strip number is 1000011 is associated with Card");
		assertEquals(1000011,card.getStrip_Number());
	}
	
	/**************************************************************************************************************************************
	 * End of Card testing methods
	 **************************************************************************************************************************************/

}
