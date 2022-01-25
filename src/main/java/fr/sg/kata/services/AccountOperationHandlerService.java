package fr.sg.kata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sg.kata.dto.Account;
import fr.sg.kata.dto.Client;
import fr.sg.kata.exceptions.ClientNotFoundException;
import fr.sg.kata.exceptions.ProblemeAjoutRetraitArgent;
import fr.sg.kata.util.TypeTransaction;

 

/**
 * The Class AccountManagerService.
 * cette classe permet de gerer les traitements des opérations des comptes clients
 */
@Service
public class AccountOperationHandlerService {
	
	/** The fake data service. */
	@Autowired
	private FakeClientDataService fakeClientDataService;
	
	@Autowired 
	private TransactionManagerService transactionManagerService;

	/**
	 * Adds the money.
	 * cette méthode permet d ajouter un montant passé en param à un compte passé en pram
	 * @param montant the montant
	 * @param account the account
	 * @return the account
	 * @throws ProblemeAjoutRetraitArgent 
	 */
	public static Account addMoney(double montant, Account account) throws ProblemeAjoutRetraitArgent {
		// tester si le compte passé en param est différent de null
		if(account!=null && montant >= 0) {
				// maj ammount du compte: ammount = amount + montant;
					account.setAmmount(account.getAmmount() + montant );
		}else {
			throw  new ProblemeAjoutRetraitArgent("Probléme lors de l'ajout");
		}
		// retourner le compte
		return account;
	}
	
	/**
	 * Retirer money.
	 * cette méthode permet de retirer un montant passé en param à un compte passé en pram
	 * @param montant the montant
	 * @param account the account
	 * @return the account
	 * @throws ProblemeAjoutRetraitArgent 
	 */
	public static Account retirerMoney(double montant, Account account) throws ProblemeAjoutRetraitArgent {
		// tester si le compte passé en param est différent de null
		if (account != null && montant>=0) {
			// maj ammount du compte: ammount = amount - montant;
			account.setAmmount(account.getAmmount() - montant);
		}else {
			throw  new ProblemeAjoutRetraitArgent("Probléme lors du retrait");
		}
		// retourner le compte
		return account;
	}
	
	
	/**
	 * Save money process.
	 * cette méthode décrit le process d ajout d argent à un compte dont l id est passé en param
	 *
	 * @param clientName the client name
	 * @param ammount the ammount
	 */
	public void saveMoneyProcess(int clientId, double ammount) {

		try {
			// chercher le client par nom
			Client clt = this.fakeClientDataService.findClientById(clientId);
			// ajouter l argent au compte
			Account account = AccountOperationHandlerService.addMoney(ammount, clt.getAccount());
			// ajouter la transaction
			TransactionManagerService.addTransactionForAccount(account, ammount, TypeTransaction.AJOUT);

		} catch (ProblemeAjoutRetraitArgent | ClientNotFoundException e) {
 
			e.printStackTrace();
		}

	}

	/**
	 * Withdraw money process.
	 * cette méthode décrit le process de retrait d'un compte dont l id est passé en param
	 * @param clientName the client name
	 * @param ammount the ammount
	 */
	public void withdrawMoneyProcess(int  clientId, double ammount) {
		
		
		try {
			// chercher le client par nom
			Client clt = this.fakeClientDataService.findClientById(clientId);
			//  Retirer l argent du compte
			Account account = AccountOperationHandlerService.retirerMoney(ammount, clt.getAccount());
			// ajouter  la   transaction 
			TransactionManagerService.addTransactionForAccount(account, ammount, TypeTransaction.RETRAIT);
			
		} catch (ProblemeAjoutRetraitArgent | ClientNotFoundException e) {
			e.printStackTrace();
		}

	}
}
