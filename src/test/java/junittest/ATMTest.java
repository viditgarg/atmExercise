/**
 * 
 */
package junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import atmprj.ATM;
import atmprj.ATMTransaction;
import atmprj.Account;
import atmprj.BankAccounts;
import atmprj.Card;

/**
 * @author PBB
 *
 */
public class ATMTest {
	
	private static Account account =null;
	private static Card card=null;
	private static BankAccounts newBankAccounts = null;
	private static ATM atm = null;
	private static ATMTransaction transaction =null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass - oneTimeSetUp");
		System.out.println("setting up an account for ATMUser with Rs. 10000 and PIN is 2244");		
		// Create a new account object for a customer named 'ATMUser' with 10000 Rupees in her account. the ATM PIN is 2244		
			account = new Account(2244, "ATMUser", 10000.00);
			
		System.out.println("setting an ATM card object for the new customer ");
		card = new Card(account.getPin(), account.getStrip_Number());
		transaction = new ATMTransaction(card.getStrip_Number());
		
		// Creating BankAccount object which will add that account 		
		newBankAccounts = new BankAccounts("MoneyBank");
				
		//Adding customer account into BankAccounts Object
		newBankAccounts.addBankAccount(account);
		
		//creating ATM related to that bank		
		atm = new ATM(newBankAccounts);
	}

	
	
	/**
	 * this method will check deposit transaction
	 */
	@Test
	public void testDepositTransaction(){
			
			transaction.setDeposit_Amt(5000);
			newBankAccounts.makeDepositAmt(transaction);
			//initial balance was 10000 so now the balance should be 15000.
			System.out.println("checking account balance after deposit of 5000:");
			assertEquals(15000, account.getAccount_Balance(),0.1);		
	}
	
	/**
	 * 
	 */
	@Test
	public void testPINVerification(){
		transaction.setPIN(card.getPin());
		transaction.setDidTheCardVerify(true);
		
		assertTrue(newBankAccounts.verifyThePIN(transaction));
	}
	
	/**
	 * this method will check if the pin is created of exactly 4 digits.
	 */
	@Test
	public void testCheckPINDigits(){
		System.out.println("this is true as checking if the pin contains 4 digits");
		assertTrue(atm.checkPINdigits(2244));
		System.out.println("this should be false because passing 5 digits, but test should pass as 4 digits should be there");
		assertFalse(atm.checkPINdigits(23456));
		System.out.println("this should be false because passing 3 digits, but test should pass as 4 digits should be there");
		assertFalse(atm.checkPINdigits(234));
	}
	
	/**
	 * this method will check withdrawal transaction
	 */
	@Test
	public void testWithdrawalTransaction(){
			
			transaction.setWithdrawalAmt(7000);;
			newBankAccounts.requestWithdrawalAmt(transaction);
			//initial balance was 10000 so now the balance should be 8000.
			System.out.println("checking account balance after withdrawing of 7000:");
			assertEquals(8000, account.getAccount_Balance(),0.1);		
	}
	
	/**
	 * this method is to test whether one can withdraw money over his current account balance
	 */
	@Test
	public void testOverWithdrawalTransaction(){
		
		System.out.println("checking if one can withdraw 70000, and the account balance is only 8000, so this test will pass if assertFalse passes");
		transaction.setWithdrawalAmt(70000);;
		assertFalse(newBankAccounts.requestWithdrawalAmt(transaction));
	}
	
	
	/***************************************************************************************************
	 * This section is to test BankAccounts object, these are 2 test methods.
	 ***************************************************************************************************/
	
	
	/**
	 * this is a tearDownAfterClass method
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass - oneTimeTearDown");
		account =null;
		card = null;
		newBankAccounts =null;
		atm =null;
	}
	
}
