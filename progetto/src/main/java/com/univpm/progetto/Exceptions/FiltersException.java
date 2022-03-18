package com.univpm.progetto.Exceptions;
/**
 *  Classe che descrive l'eccezione durante i metodi legati ai filtri
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class FiltersException extends Exception {

	private static final long serialVersionUID = 1L;
	public FiltersException() {
		super("ERRORE(Filters): operazione non andata a buon fine!");
	}
}
