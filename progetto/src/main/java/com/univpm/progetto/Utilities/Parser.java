package com.univpm.progetto.Utilities;
/**
 * Classe per prendere la api key
 * @author Lorenzo Zulli e Giovanni Prati
 */

public class Parser {
    private String api_key;

    Parser(String api_key){
        this.api_key = api_key;
    }
    /**
     * @return String return the api_key
     */
    public String getApi_key() {
        return api_key;
    }

    /**
     * @param api_key the api_key to set
     */
    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

}
