package fr.sg.kata.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import fr.sg.kata.dto.Account;
import fr.sg.kata.exceptions.ProblemeAjoutRetraitArgent;


/**
 * The Class AccountManagerServiceTest.
 */
class AccountManagerServiceTest {

	/**
	 * Test si account null.
	 * @throws ProblemeAjoutRetraitArgent 
	 */
	@Test
	void testSiAccountNull() throws ProblemeAjoutRetraitArgent {
			Account result = AccountOperationHandlerService.addMoney(Mockito.anyInt(), null);
			assertEquals(null, result);
	}
	
	/**
	 * Test ajout un montant.
	 * @throws ProblemeAjoutRetraitArgent 
	 */
	@Test
	void testAjoutUnMontant() throws ProblemeAjoutRetraitArgent {
		Account account = new Account();
		account.setAmmount(30);
		Account result = AccountOperationHandlerService.addMoney(30, account);
		assertEquals(60, result.getAmmount());
	}
	
	/**
	 * Test retirer un montant dun account null.
	 * @throws ProblemeAjoutRetraitArgent 
	 */
	@Test
	public void testRetirerUnMontantDunAccountNull() throws ProblemeAjoutRetraitArgent {
		Account result = AccountOperationHandlerService.retirerMoney(Mockito.anyInt(), null);
		assertEquals(null, result);
	}
	
	/**
	 * Test retirer un montant.
	 * @throws ProblemeAjoutRetraitArgent 
	 */
	@Test
	void testRetirerUnMontant() throws ProblemeAjoutRetraitArgent {
		Account account = new Account();
		account.setAmmount(30);
		Account result = AccountOperationHandlerService.retirerMoney(30, account);
		assertEquals(0, result.getAmmount());
	}
}
