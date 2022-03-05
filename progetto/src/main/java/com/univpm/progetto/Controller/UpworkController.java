package com.univpm.progetto.Controller;

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
    /**
     * Rotta per avviare la ricerca degli utenti con la skill Java
     */
    @GetMapping(value = "/search")
    public void startSearch(@RequestBody /*da mettere il tipo*/ body){
        //inserire il codice
    }
    /**
     * Rotta per generare le stats
     */
    @PostMapping(value = "/stats")
    public void stats(@RequestBody /*da mettere il tipo*/ body){
        //inserire il codice
    }
    /**
     * Rotta per generare i filters
     */
    @PostMapping(value = "/filters")
    public void filters(@RequestBody /*da mettere il tipo*/ body){
        //inserire il codice
    }
}
