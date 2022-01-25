package fr.sg.kata.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sg.kata.dto.Account;
import fr.sg.kata.dto.Transaction;
import fr.sg.kata.exceptions.ClientNotFoundException;
import fr.sg.kata.util.TypeTransaction;

@Service
public class TransactionManagerService {
	
	@Autowired
	private FakeClientDataService fakeClientDataService;
	
	public static int compteurIdTransaction;

	/**
	 * Adds the transaction for account.
	 *
	 * @param account the account
	 * @return the list
	 */
	public static List<Transaction> addTransactionForAccount(Account account, double ammount, TypeTransaction type) {
		// tester si le compte passé en param n est pas null
		if (account != null) {
			// tester si le compte ne posséde pas une liste de transaction
			if (account.getTransactionsList() == null) {
				// on crée un nouvelle liste
				List newTransList = new ArrayList<>();
				// on l affecte au compte
				account.setTransactionsList(new ArrayList<>());

			}
			// on crée la transaction et on l ajoute à la liste des transaction du compte
			account.getTransactionsList()
					.add(new Transaction(++compteurIdTransaction, new Date(), ammount, account.getAmmount(), type));
			return account.getTransactionsList();
		}
		return null;

	}
	
	/**
	 * Gets the transactions by client dont l'id est passé par param.
	 *
	 * @param clientId the client Id
	 * @return the transactions by client
	 */
	public List<Transaction> getTransactionsByClient(int clientId) {
		try {
			return this.fakeClientDataService.findClientById(clientId).getAccount().getTransactionsList();
		} catch (ClientNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
