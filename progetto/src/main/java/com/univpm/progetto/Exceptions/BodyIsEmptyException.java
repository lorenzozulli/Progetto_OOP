package com.univpm.progetto.Exceptions;
//Classe che descrive l'eccezione nel caso in cui il body sia vuoto

public class BodyIsEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BodyIsEmptyException() {
		super();
	}
	
	public BodyIsEmptyException(String message) {
		super(message);
	}

}