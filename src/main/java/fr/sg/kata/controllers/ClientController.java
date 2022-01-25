package fr.sg.kata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sg.kata.dto.Client;
import fr.sg.kata.services.FakeClientDataService;
import fr.sg.kata.util.Urls;

/**
 * The Class ClientController.
 */
@RestController
@RequestMapping(Urls.CLIENT_CONTROLLER)
public class ClientController {
	
	/** The fake data service. */
	@Autowired
	private FakeClientDataService fakeClientDataService;
	
	/**
	 * Gets the list client.
	 *
	 * @return the list client
	 */
	@GetMapping(Urls.GET_LIST_CLIENT)
	public  List<Client> getListClient() {
		return fakeClientDataService.getClientList();
	}
	
	 
}
