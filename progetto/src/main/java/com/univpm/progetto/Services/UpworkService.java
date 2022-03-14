package com.univpm.progetto.Services;

import com.univpm.progetto.StatsandFilters.Filters;
import com.univpm.progetto.StatsandFilters.Stats;

import java.util.Vector;

import com.univpm.progetto.Exceptions.FiltersException;
import com.univpm.progetto.Exceptions.StatsException;
import com.univpm.progetto.Models.Freelancer;
//import com.univpm.progetto.Models.Users;
import com.univpm.progetto.Utilities.UsersParser;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe contente i metodi del servizio del programma
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
        JSONArray responsebody = new JSONArray();
        usersRequest();
        return responsebody;
    }
    /**
     * Metodo per generare le stats
     * @return stats
     * @throws StatsException
     */
    public JSONObject statsGenerator(Vector<Freelancer> f) throws StatsException{
        JSONObject stats = new JSONObject();
        stats.put("average portfolio_items_count", this.stats.portfolioAverage(f));
        stats.put("variance portfolio_items_count", this.stats.portfolioVariance(f));
        stats.put("average skills", this.stats.skillAverage(f));
        stats.put("variance skills", this.stats.skillVariance(f));
        return stats;
    }
    /**
     * Metodi per generare il filtro per feedback
     * @return filters
     * @throws FiltersException
     */
    public JSONArray feedbackFilterGenerator() throws FiltersException{
        Vector<Freelancer> f = new Vector<Freelancer>();
        JSONArray filters = new JSONArray();
        this.filters.ordinoPerFeedback(f);
        return filters;
    }
    /**
     * Metodo per generare il filtro per dimensione del portfolio
     * @return filters
     * @throws FiltersException
     */
    public JSONArray portfolioFilterGenerator()throws FiltersException{
        Vector<Freelancer> f = new Vector<Freelancer>();
        JSONArray filters = new JSONArray();
        this.filters.ordinoPerDimensionePortfolio(f);
        return filters;
    }
    
}
