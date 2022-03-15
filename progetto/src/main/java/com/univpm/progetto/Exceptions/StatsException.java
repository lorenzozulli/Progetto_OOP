package com.univpm.progetto.Exceptions;
/**
 *  Classe che descrive l'eccezione durante i metodi legati al calcolo delle statistiche
 *  @author Lorenzo Zulli, Giovanni Prati
 */

public class StatsException extends Exception {
	
	public StatsException() {
		super("ERRORE(Stats): operazione non andata a buon fine!");
	}
}
