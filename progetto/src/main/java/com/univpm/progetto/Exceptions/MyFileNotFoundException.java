package com.univpm.progetto.Exceptions;
/**
 * Classe che descrive l'eccezione durante la lettura di un file
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */
public class MyFileNotFoundException extends Exception {
	/**
	 * stringa con messaggio di errore
	 */
	public static String output= "ERRORE: non è stato possibile trovare il file!";

	private static final long serialVersionUID = 1L;
	
	/**
	 * costruttore di MyFileNotFoundException
	 */
    public MyFileNotFoundException() {
		super(output);
    }
    /**
     * 
     * @return ritorna output
     */
    public String getOutput() {
    	return output;
    }
}
