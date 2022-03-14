package com.univpm.progetto.Models;

import org.json.simple.*;

/**
 * 
 * Interfaccia che mostra la funzione toJSONObject() e viene implementata da tutte le classi 
 * 
 * @author Lorenzo Zulli, Giovanni Prati
 */
public interface JSONAble {
    public JSONObject toJSONObject();
}