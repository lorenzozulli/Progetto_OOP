package com.univpm.progetto;

import org.springframework.web.bind.annotation.GetMapping;

public class StatsAndFilters {
    public void countSkills(){

    }
    public void portfolioAverage(){

    }
    public void portfolioVariance(){

    }
    public void skillAverage(){
        countSkills();
    }
    public void skillVariance(){
        countSkills();
    }
}
