package com.univpm.progetto.Utilities;

/**
 * Classe per prendere la api key
 * @author Lorenzo Zulli, Giovanni Prati
 */
public class Parser {
    private String api_key;
    
    Parser(String api_key){
        this.api_key = api_key;
    }
    /**
     * Getter per api_key
     * @return api_key
     */
    public String getApi_key() {
        return api_key;
    }

    /**
     * Setter per api_key
     * @param api_key
     */
    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }
}
