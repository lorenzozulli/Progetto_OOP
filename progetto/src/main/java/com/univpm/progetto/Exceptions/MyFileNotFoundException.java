package com.univpm.progetto.Exceptions;
/**
 *  Classe che descrive l'eccezione durante la lettura di un file
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class MyFileNotFoundException extends Exception {
	public static String output= "ERRORE: non è stato possibile trovare il file!";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public MyFileNotFoundException() {
		super(output);
    }
    public String getOutput() {
    	return output;
    }
}
