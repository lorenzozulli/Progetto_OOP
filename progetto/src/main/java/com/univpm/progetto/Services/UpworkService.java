package com.univpm.progetto.Services;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe contente i metodi di servizio
 * @author Lorenzo Zulli, Giovanni Prati
 */

public class UpworkService {
    /**
     * Metodo per avviare una ricerca
     * @return search
     */
    public JSONArray startSearch(){
        // insert code here
        JSONArray search = new JSONArray();
        return search;
    }
    /**
     * Metodo per generare le stats
     * @return stats
     */
    public JSONObject statsGenerator(){
        //insert code here
        Freelancer freelancer = new Freelancer();
        JSONObject stats = new JSONObject();
        stats.put("average portfolio_items_count", freelancer.portfolioAverage());
        stats.put("variance portfolio_items_count", freelancer.portfolioVariance());
        stats.put("average skills", freelancer.skillAverage());
        stats.put("variance skills", freelancer.skillVariance());
        return stats;
    }
    /**
     * Metodi per generare i filtri
     * @return filters
     */
    public JSONArray feedbackFilterGenerator(){
        //insert code here
        JSONArray filters = new JSONArray();
        return filters;
    }
    public JSONArray portfolioFilterGenerator(){
        //insert code here
        JSONArray filters = new JSONArray();
        return filters;
    }
    
}
