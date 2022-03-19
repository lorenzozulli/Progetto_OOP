package com.univpm.progetto.Controller;

import com.univpm.progetto.Exceptions.BadRequestException;
import com.univpm.progetto.Exceptions.FiltersException;
import com.univpm.progetto.Exceptions.StatsException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Services.UpworkService;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe che contiene i metodi del Controller 
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */
@RestController
public class UpworkController {
    UpworkService upworkservice = new UpworkService();
    /**
     * Rotta per iniziare la ricerca degli utenti con la skill java
     * @param body
     * @return JSONArray contenente gli utenti con la skill java
     * @throws BadRequestException
     */
    @GetMapping(value = "/searchjava")
    public JSONArray startSearch() throws BadRequestException{
        return upworkservice.searchJava();
    }
    /**
     * Rotta per generare le statistiche
     * @param body
     * @return JSONObject contenente le statistiche
     * @throws StatsException
     */
    @GetMapping(value = "/stats")
    public JSONObject stats() throws BadRequestException, StatsException{
        Vector<Freelancer> f = new Vector<Freelancer>();
        f = this.fParser.parser();
        return upworkservice.statsGenerator(f);
    }
   /**
    * Rotta per generare il filtro per feedback
    * @param body
    * @return JSONArray ordinato per <b>feedback</b>
    * @throws FiltersException
    */
    @GetMapping(value = "/filters/feedback")
    public JSONArray feedbackFilter() throws FiltersException{
        UpworkService upworkservice = new UpworkService();
        return upworkservice.feedbackFilterGenerator();
    }
    /**
     * Rotta per generare il filtro per dimensione del portfolio
     * @param body
     * @return JSONArray ordinato per <b>portfolio_items_count</b>
     * @throws FiltersException
     */
    @GetMapping(value = "/filters/portfolio")
    public JSONArray portfolioFilter() throws FiltersException{
        UpworkService upworkservice = new UpworkService();
        return upworkservice.portfolioFilterGenerator();
    }
}
