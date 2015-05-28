package junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import atmprj.Account;

public class TestAccount {
	
	private static Account account =null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("------------Now TestAccount tests will run--------\n");
		System.out.println("setting up an account for ATMUser with Rs. 10000 and PIN is 2244");		
		// Create a new account object for a customer named 'ATMUser' with 10000 Rupees in her account. the ATM PIN is 2244		
			account = new Account(2244, "ATMUser", 10000.00);	
			
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {		
		account =null;
		
		System.out.println("-----------------End of TestAccount tests----\n");
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAccountCreatedSucessfully(){
		System.out.println("Testing if Account object is created sucessfully-");
		assertNotNull(account);		
	}
	
	@Test
	public void testAccountHolderName(){
		System.out.println("testing if the name is 'ATMUser'");
		assertEquals("ATMUser", account.getCustomer_Name());
	}
	
	@Test
	public void testPINNumber(){
		System.out.println("Testing if PIN number is 2244 for ATMUser");
		assertEquals(2244, account.getPin());
	}
	
	@Test
	public void testCardStripNumber(){
		System.out.println("Testing if strip number is 1000011 for ATMUser");
		assertEquals(1000011,account.getStrip_Number());
	}
	
	@Test
	public void testAccountBalance(){
		System.out.println("Testing if account balance is 10000.00 for ATMUser:");
		assertEquals(10000, account.getAccount_Balance(),0.1);
		
	}
	
	@Test
	public void testAccountNumber(){
		System.out.println("Testing if account number is 1000011 for ATMUser");
		assertEquals(1000011,account.getAccount_Number());
	}

}
