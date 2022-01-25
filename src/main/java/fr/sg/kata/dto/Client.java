package fr.sg.kata.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

/**
 * Instantiates a new client.
 *
 * @param id the id
 * @param nom the nom
 * @param prenom the prenom
 * @param account the account
 */
@AllArgsConstructor
public class Client  implements Serializable {

 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private int id;
	
	/** The nom. */
	private String nom; 
	
	/** The prenom. */
	private String prenom;
	
	/** The account. */
	private Account account;
}
