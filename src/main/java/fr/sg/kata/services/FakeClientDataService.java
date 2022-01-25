package fr.sg.kata.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import fr.sg.kata.dto.Account;
import fr.sg.kata.dto.Client;
import fr.sg.kata.exceptions.ClientNotFoundException;
import lombok.Getter;


@Getter
@Service
/**
 * cette classe permet de génerer les fake data des clients puisque on n'a pas une source de données */
public class FakeClientDataService {
	
	/** The client list. */
	private List<Client> clientList = new ArrayList<>();
	
	/** The Constant NBR_MAX_CLIENT. */
	private static final int NBR_MAX_CLIENT = 3;
	
	
	/**
	 * Generate fake client.
	 *
	 * @param id the id
	 * @return the client
	 */
	private static Client generateFakeClient(int id) {
		// creation du compte
		Account account = new Account();

		// generation du nom randomly
		String nom = UUID.randomUUID().toString();

		// generation du prenonom randomly
		String prenom = UUID.randomUUID().toString();

		// création du client
		Client client = new Client(id, nom, prenom, account);
		return client;

	}
	
	/**
	 * Generate client list.
	 */
	@PostConstruct
	private void generateClientList() {
		for (int i = 1; i <= NBR_MAX_CLIENT; i++) {
			clientList.add(generateFakeClient(i));
		}
	}
	
	

	/**
	 * Find client by id.
	 *
	 * @param id the id
	 * @return the client
	 * @throws ClientNotFoundException 
	 */
	public Client findClientById(int id) throws ClientNotFoundException{
	return this.clientList.stream().filter(clt -> clt.getId() == id)
			  .findFirst()
			  .orElseThrow(() -> new ClientNotFoundException("No client with id: "+ id));
	}
}
