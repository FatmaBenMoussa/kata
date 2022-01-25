package fr.sg.kata.exceptions;

/**
 * The Class ProblemeAjoutRetraitArgent.
 */
public class ProblemeAjoutRetraitArgent extends Exception   {
 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new probleme ajout retrait argent.
	 *
	 * @param errorMessage the error message
	 */
	public ProblemeAjoutRetraitArgent(String errorMessage) {
        super(errorMessage);
    }
}
