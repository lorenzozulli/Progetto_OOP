package com.univpm.progetto.Services;

import com.univpm.progetto.StatsandFilters.Filters;
import com.univpm.progetto.StatsandFilters.Stats;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Utilities.FreelancersParser;

import com.univpm.progetto.Exceptions.BadRequestException;
import com.univpm.progetto.Exceptions.FiltersException;
import com.univpm.progetto.Exceptions.StatsException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Vector;

/**
 * Classe contente i metodi del Service
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class UpworkService {

    private Stats stats;
    private Filters filters;

    /**
     * Metodo per avviare una ricerca
     * @return search
     * @throws BadRequestException
     */
    public JSONArray searchJava() throws BadRequestException{
        FreelancersParser fParser = new FreelancersParser();
        Vector<Freelancer> f = new Vector<Freelancer>();
        f = fParser.parser();
        JSONArray ja = new JSONArray();
        for(int i=0;i<f.size();i++){
            ja.add(f.get(i).toJSONObject());
        }
        return ja;
    }
    /**
     * Metodo per generare le statistiche attraverso un <b>JSONObject</b>
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
     * Metodo per generare il filtro per <b>feedback</b>
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
     * Metodo per generare il filtro per <b>portfolio_items_count</b>
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
