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

    /**
     * Metodo per avviare una ricerca
     * @return search
     * @throws BadRequestException
     */
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public JSONObject statsGenerator(Vector<Freelancer> f) throws StatsException{
        JSONObject stats = new JSONObject();
        Stats _stats = new Stats();
        stats.put("average portfolio_items_count", _stats.portfolioAverage(f));
        stats.put("variance portfolio_items_count", _stats.portfolioVariance(f));
        stats.put("average skills", _stats.skillAverage(f));
        stats.put("variance skills", _stats.skillVariance(f));
        return stats;
    }
    /**
     * Metodo per generare il filtro per <b>feedback</b>
     * @return filters
     * @throws FiltersException
     */
    @SuppressWarnings("unchecked")
    public JSONArray feedbackFilterGenerator(Vector<Freelancer> f) throws FiltersException{
        Filters _filters = new Filters();
        JSONArray filters = new JSONArray();
        _filters.ordinoPerFeedback(f);
        for(int i=0;i<f.size();i++){
            filters.add(f.get(i).toJSONObject());
        }
        return filters;
    }
    /**
     * Metodo per generare il filtro per <b>portfolio_items_count</b>
     * @return filters
     * @throws FiltersException
     */
    @SuppressWarnings("unchecked")
    public JSONArray portfolioFilterGenerator(Vector<Freelancer> f)throws FiltersException{
        Filters _filters = new Filters();
        JSONArray filters = new JSONArray();
        _filters.ordinoPerDimensionePortfolio(f);
        for(int i=0;i<f.size();i++){
            filters.add(f.get(i).toJSONObject());
        }
        return filters;
    }
    
}
