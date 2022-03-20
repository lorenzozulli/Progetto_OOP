package com.univpm.progetto.Controller;

import com.univpm.progetto.Exceptions.MyFileNotFoundException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Services.UpworkService;
import com.univpm.progetto.Utilities.FreelancersParser;

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
public class UpworkController{
    UpworkService upworkservice = new UpworkService();
    /**
     * Rotta per iniziare la ricerca degli utenti con la skill java
     * @return JSONArray contenente gli utenti con la skill java
     * @throws MyFileNotFoundException
     */
    @GetMapping(value = "/search")
    public JSONArray startSearch() throws MyFileNotFoundException{
            return upworkservice.searchJava();
    }
    /**
     * Rotta per generare le statistiche
     * @return JSONObject contenente le statistiche
     * @throws MyFileNotFoundException Eccezione di tipo MyFileNotFound
     */
    @GetMapping(value = "/stats")
    public JSONObject stats() throws MyFileNotFoundException{
        Vector<Freelancer> f = new Vector<Freelancer>();
        FreelancersParser fParser = new FreelancersParser();
        f = fParser.parser();
        return upworkservice.statsGenerator(f);
    }
   /**
    * Rotta per generare il filtro per feedback
    * @return JSONArray ordinato per <b>feedback</b>
    * @throws MyFileNotFoundException Eccezione di tipo MyFileNotFound
    */
    @GetMapping(value = "/filters/feedback")
    public JSONArray feedbackFilter() throws MyFileNotFoundException{
        Vector<Freelancer> f = new Vector<Freelancer>();
        FreelancersParser fParser = new FreelancersParser();
        f = fParser.parser();
        return upworkservice.feedbackFilterGenerator(f);
    }
    /**
     * Rotta per generare il filtro per dimensione del portfolio
     * @return JSONArray ordinato per <b>portfolio_items_count</b>
     * @throws MyFileNotFoundException Eccezione di tipo MyFileNotFound
     */
    @GetMapping(value = "/filters/portfolio")
    public JSONArray portfolioFilter() throws MyFileNotFoundException{
        Vector<Freelancer> f = new Vector<Freelancer>();
        FreelancersParser fParser = new FreelancersParser();
        f = fParser.parser();
        return upworkservice.portfolioFilterGenerator(f);
    }
}
