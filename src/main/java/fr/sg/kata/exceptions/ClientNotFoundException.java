package fr.sg.kata.exceptions;

 
/**
 * The Class ClientNotFoundException.
 */
public class ClientNotFoundException extends Exception {
 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new client not found exception.
	 *
	 * @param errorMessage the error message
	 */
	public ClientNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
