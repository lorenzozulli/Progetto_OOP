package com.univpm.progetto.Controller;

import com.univpm.progetto.Exceptions.BadRequestException;
import com.univpm.progetto.Exceptions.FiltersException;
import com.univpm.progetto.Exceptions.StatsException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Services.UpworkService;
import com.univpm.progetto.Utilities.UsersParser;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Vector;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe che contiene i metodi del controller 
 * @author Lorenzo Zulli, Giovanni Prati
 */
@RestController
public class UpworkController {
    private UpworkService upworkservice;
    private UsersParser usersparser;
    /**
     * Rotta per iniziare la ricerca degli utenti con la skill java
     * @param body
     * @return
     * @throws BadRequestException
     */
    @PostMapping(value = "/searchjava")
    public void startSearch(@RequestBody JSONObject body) throws BadRequestException{
        //inserire il codice
        System.out.println(upworkservice.startSearch());
    }
    /**
     * Rotta per generare le statistiche
     * @param body
     * @return JSONObject contente le statistiche
     * @throws StatsException
     */
    @PostMapping(value = "/stats")
    public JSONObject stats(@RequestBody JSONArray body) throws StatsException{
        //inserire il codice
        return upworkservice.statsGenerator(body);
    }
   /**
    * Rotta per generare il filtro per feedback
    * @param body
    * @return JSONArray ordinato per <b>feedback</b>
    * @throws FiltersException
    */
    @PostMapping(value = "/filters/feedback")
    public JSONArray feedbackFilter(@RequestBody JSONObject body) throws FiltersException{
        //inserire il codice
        return upworkservice.feedbackFilterGenerator();
    }
    /**
     * Rotta per generare il filtro per dimensione del portfolio
     * @param body
     * @return JSONArray ordinato per <b>portfolio_items_count</b>
     * @throws FiltersException
     */
    @PostMapping(value = "/filters/portfolio")
    public JSONArray portfolioFilter(@RequestBody JSONObject body) throws FiltersException{
        //inserire il codice
        return upworkservice.portfolioFilterGenerator();
    }
}
