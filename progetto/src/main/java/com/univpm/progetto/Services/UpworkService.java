package com.univpm.progetto.Services;

import com.univpm.progetto.StatsandFilters.Filters;
import com.univpm.progetto.StatsandFilters.Stats;
import com.univpm.progetto.Models.Freelancer;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe contente i metodi di servizio
 * @author Lorenzo Zulli, Giovanni Prati
 */

public class UpworkService {

    private Stats stats;
    private Filters filters;

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
        Freelancer freelancer = new Freelancer();
        JSONObject stats = new JSONObject();
        stats.put("average portfolio_items_count", this.stats.portfolioAverage());
        stats.put("variance portfolio_items_count", this.stats.portfolioVariance());
        stats.put("average skills", this.stats.skillAverage());
        stats.put("variance skills", this.stats.skillVariance());
        return stats;
    }
    /**
     * Metodi per generare i filtri
     * @return filters
     */
    public JSONArray feedbackFilterGenerator(){
        JSONArray filters = new JSONArray();
        this.filters.ordinoPerFeedback();
        return filters;
    }
    public JSONArray portfolioFilterGenerator(){
        JSONArray filters = new JSONArray();
        this.filters.ordinoPerDimensionePortfolio();
        return filters;
    }
    
}
