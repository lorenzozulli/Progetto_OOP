package com.univpm.progetto.Controller;

import com.univpm.progetto.Exceptions.BadRequestException;
import com.univpm.progetto.Exceptions.FiltersException;
import com.univpm.progetto.Exceptions.StatsException;
import com.univpm.progetto.Services.UpworkService;

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
    /**
     * Rotta per avviare la ricerca degli utenti con la skill Java
     */
    @PostMapping(value = "/searchjava")
    public JSONArray startSearch(@RequestBody JSONObject body) throws BadRequestException{
        //inserire il codice
        return upworkservice.startSearch();
    }
    /**
     * Rotta per generare le stats
     */
    @PostMapping(value = "/stats")
    public JSONObject stats(@RequestBody JSONObject body) throws StatsException{
        //inserire il codice
        return upworkservice.statsGenerator();
    }
    /**
     * Rotta per generare i filters
     */
    @PostMapping(value = "/filters/feedback")
    public JSONArray feedbackFilter(@RequestBody JSONObject body) throws FiltersException{
        //inserire il codice
        return upworkservice.feedbackFilterGenerator();
    }
    @PostMapping(value = "/filters/portfolio")
    public JSONArray portfolioFilter(@RequestBody JSONObject body) throws FiltersException{
        //inserire il codice
        return upworkservice.portfolioFilterGenerator();
    }
}
