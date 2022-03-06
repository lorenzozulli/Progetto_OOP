package com.univpm.progetto.Controller;

import com.univpm.progetto.Services.UpworkService;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value = "/search")
    public JSONObject startSearch(@RequestBody JSONObject body){
        //inserire il codice
        return upworkservice.startSearch();
    }
    /**
     * Rotta per generare le stats
     */
    @PostMapping(value = "/stats")
    public JSONObject stats(@RequestBody JSONObject body){
        //inserire il codice
        return upworkservice.statsGenerator();
    }
    /**
     * Rotta per generare i filters
     */
    @PostMapping(value = "/filters")
    public JSONObject filters(@RequestBody JSONObject body){
        //inserire il codice
        return upworkservice.filtersGenerator();
    }
}
