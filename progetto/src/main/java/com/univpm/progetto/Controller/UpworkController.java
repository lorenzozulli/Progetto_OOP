package com.univpm.progetto.Controller;

import java.util.Vector;

import com.univpm.progetto.Exceptions.BadRequestException;
import com.univpm.progetto.Exceptions.FiltersException;
import com.univpm.progetto.Exceptions.StatsException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Models.Users;
import com.univpm.progetto.Services.UpworkService;
import com.univpm.progetto.Utilities.UsersParser;

import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller del programma
 * @author Lorenzo Zulli, Giovanni Prati
 */
@RestController
public class UpworkController {
    private UpworkService upworkservice;
    private UsersParser usersparser;
    /**
     * Rotta per iniziare la ricerca degli utenti con la skill "java"
     * @param body
     * @return
     * @throws BadRequestException
     */
    @PostMapping(value = "/searchjava")
    public Vector<Freelancer> startSearch(@RequestBody JSONObject body) throws BadRequestException{
        //inserire il codice
        Vector<Freelancer> f = new Vector<Freelancer>();
        this.usersparser.usersRequest();
        return f;
    }
    /**
     * Rotta per generare le statistiche
     * @param body
     * @return
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
    * @return
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
     * @return
     * @throws FiltersException
     */
    @PostMapping(value = "/filters/portfolio")
    public JSONArray portfolioFilter(@RequestBody JSONObject body) throws FiltersException{
        //inserire il codice
        return upworkservice.portfolioFilterGenerator();
    }
}
