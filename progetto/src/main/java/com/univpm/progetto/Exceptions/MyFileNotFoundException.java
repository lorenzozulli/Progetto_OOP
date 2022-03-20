package com.univpm.progetto.Exceptions;

public class MyFileNotFoundException extends Exception {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyFileNotFoundException() {
        super();
    }
    public MyFileNotFoundException(String msg) {
        super(msg);
    }
}
