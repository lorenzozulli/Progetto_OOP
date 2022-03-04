package com.univpm.progetto.Exceptions;
/**
 * Classe che descrive l'ccezione nel caso di richiesta errata all'API di Upwork
 * @author
 */

public class BadRequestException extends Exception {

    public BadRequestException(){
        super("La richesta all'API di Upwork non è andata a buon fine");
    }
}
