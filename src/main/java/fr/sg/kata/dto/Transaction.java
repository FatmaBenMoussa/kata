package fr.sg.kata.dto;

import java.io.Serializable;
import java.util.Date;

import fr.sg.kata.util.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


 
// TODO: Auto-generated Javadoc
/**
 * Gets the type transaction.
 *
 * @return the type transaction
 */
@Getter

/**
 * Sets the type transaction.
 *
 * @param typeTransaction the new type transaction
 */
@Setter
/**
 * Instantiates a new transaction.
 *
 * @param transactionId the transaction id
 * @param date the date
 * @param ammount the ammount
 * @param typeTransaction the type transaction
 */

/**
 * Instantiates a new transaction.
 *
 * @param transactionId the transaction id
 * @param date the date
 * @param ammount the ammount
 * @param balance the balance
 * @param typeTransaction the type transaction
 */
@AllArgsConstructor
public class Transaction  implements Serializable{
 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The transaction id. */
	private int transactionId;
	
	/** The date. */
	private Date date;
	
	/** The ammount. */
	private double ammount;  
	
	/** The balance. */
	private double balance;
	
	/** The type transaction. */
	private TypeTransaction typeTransaction;
	
}
