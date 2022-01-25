package fr.sg.kata.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class Account implements Serializable {
 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ammount. */
	private double ammount;
	
	/** The transactions list. */
	private List<Transaction> transactionsList;
	
 
	
	
}
