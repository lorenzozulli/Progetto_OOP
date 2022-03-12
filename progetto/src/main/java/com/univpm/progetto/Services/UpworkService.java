package com.univpm.progetto.Services;

import com.univpm.progetto.StatsandFilters.Filters;
import com.univpm.progetto.StatsandFilters.Stats;
//import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Models.Users;

import org.json.JSONArray;
import org.json.JSONObject;

//import java.util.Vector;

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
        //Vector<Freelancer> f = new Vector<Freelancer>(); 
        Users f = new Users();
        JSONObject stats = new JSONObject();
        stats.put("average portfolio_items_count", this.stats.portfolioAverage(f.getFreelancers()));
        stats.put("variance portfolio_items_count", this.stats.portfolioVariance(f.getFreelancers()));
        stats.put("average skills", this.stats.skillAverage(f.getFreelancers()));
        stats.put("variance skills", this.stats.skillVariance(f.getFreelancers()));
        return stats;
    }
    /**
     * Metodi per generare i filtri
     * @return filters
     */
    public JSONArray feedbackFilterGenerator(){
        Users f = new Users();
        JSONArray filters = new JSONArray();
        this.filters.ordinoPerFeedback(f.getFreelancers());
        return filters;
    }
    public JSONArray portfolioFilterGenerator(){
        Users f = new Users();
        JSONArray filters = new JSONArray();
        this.filters.ordinoPerDimensionePortfolio(f.getFreelancers());
        return filters;
    }
    
}
