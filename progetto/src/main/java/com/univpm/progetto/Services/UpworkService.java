package com.univpm.progetto.Services;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.univpm.progetto.Exceptions.MyFileNotFoundException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.StatsandFilters.Filters;
import com.univpm.progetto.StatsandFilters.Stats;
import com.univpm.progetto.Utilities.FreelancersParser;
/**
 * Classe contente i metodi del Service
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class UpworkService {

    /**
     * Metodo per avviare una ricerca
     * @return search
     * @throws MyFileNotFoundException
     */
    @SuppressWarnings("unchecked")
	public JSONArray searchJava() throws MyFileNotFoundException{
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
     * @param f vettore di freelancers
     */
    @SuppressWarnings("unchecked")
	public JSONObject statsGenerator(Vector<Freelancer> f) {
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
     * @param f vettore di freelancers
     */
    @SuppressWarnings("unchecked")
	public JSONArray feedbackFilterGenerator(Vector<Freelancer> f){
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
     * @param f vettore di freelancers
     */
    @SuppressWarnings("unchecked")
	public JSONArray portfolioFilterGenerator(Vector<Freelancer> f){
        Filters _filters = new Filters();
        JSONArray filters = new JSONArray();
        _filters.ordinoPerDimensionePortfolio(f);
        for(int i=0;i<f.size();i++){
            filters.add(f.get(i).toJSONObject());
        }
        return filters;
    }
    
}
