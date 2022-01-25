package fr.sg.kata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.sg.kata.dto.Transaction;
import fr.sg.kata.services.TransactionManagerService;
import fr.sg.kata.util.Urls;


/**
 * The Class TransactionController.
 */
@RestController
@RequestMapping(Urls.TRANSACTION_CONTROLLER)
public class TransactionController {

	/** The transaction manager service. */
	@Autowired
	private TransactionManagerService transactionManagerService;
	
	/**
	 * Gets the client transctions.
	 *
	 * @param clientId the client id
	 * @return the client transctions
	 */
	@GetMapping(Urls.GET_CLIENT_TRASACTION)
	public List<Transaction> getClientTransctions(@RequestParam int clientId){
		return transactionManagerService.getTransactionsByClient(clientId);
	}
}
