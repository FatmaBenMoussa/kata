package fr.sg.kata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.sg.kata.services.AccountOperationHandlerService;
import fr.sg.kata.util.Urls;

/**
 * The Class AccountController.
 */
@RestController
@RequestMapping(Urls.ACCOUNT_CONTROLLER)
public class AccountController {
	
	/** The account operation handler service. */
	@Autowired
	private AccountOperationHandlerService accountOperationHandlerService;
	
	
	/**
	 * Save money.
	 *
	 * @param clientId the client id
	 * @param ammount the ammount
	 */
	@PostMapping(Urls.SAVE_MONEY)
	public void saveMoney(@RequestParam  int clientId, @RequestParam double ammount) {
		this.accountOperationHandlerService.saveMoneyProcess(clientId, ammount);
	}
	
	/**
	 * Withdraw money.
	 *
	 * @param clientId the client id
	 * @param ammount the ammount
	 */
	@PostMapping(Urls.WITHDRAW_MONEY)
	public void withdrawMoney(@RequestParam  int clientId,@RequestParam double ammount) {
		this.accountOperationHandlerService.withdrawMoneyProcess(clientId, ammount);
	}

}
