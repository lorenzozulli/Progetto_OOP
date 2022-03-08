package com.univpm.progetto.Exceptions;
/**
 * Classe che descrive l'eccezione nel caso di richiesta errata all'API di Upwork
 * @author Lorenzo Zulli, Giovanni Prati
 */

public class BadRequestException extends Exception {

    public BadRequestException(){
        super("La richesta all'API di Upwork non è andata a buon fine");
    }
}
