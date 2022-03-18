package com.univpm.progetto.StatsandFilters;

import com.univpm.progetto.Models.Freelancer;

import java.util.Vector;


/**
 * Classe per ottenere le statistiche relative ai freelancers
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class Stats{
    /**
     * Metodo per ottenere la media di progetti nel portfolio
     * @return Media di <b>portfolio_items_count</b>
     * @param users
     */
    public double portfolioAverage(Vector<Freelancer> users){
        double sumportfolioitems = 0;
        for(Freelancer s : users)
            sumportfolioitems += s.getPortfolio_items_count();
        return (sumportfolioitems/users.size());
    }
    /**
     * Metodo per ottenere la varianza di progetti nel portfolio 
     * @return Varianza di <b>portfolio_items_count</b>
     * @param users
     */
    public double portfolioVariance(Vector<Freelancer> users){
        double k, g=0;
        for (Freelancer s : users) {
            // calcolo della varianza
            k = s.getPortfolio_items_count() - portfolioAverage(users);
            g += k*k;
        }
        return (g/users.size());
    }
    /**
     * Metodo per ottenere la media del numero di skill
     * @return Media del numero di <b>skills</b>
     * @param users
     */
    public double skillAverage(Vector<Freelancer> users){
        double sumskills = 0;
        for (Freelancer s : users){
            sumskills += s.getSkills().length;
        }
        return (sumskills/users.size());
    }
    /**
     * Metodo per ottenere la varianza di numero di skill
     * @return Varianza del numero di <b>skills</b>
     * @param users
     */
    public double skillVariance(Vector<Freelancer> users){
        double k=0, g=0;
        //sumskills = 0;
        for (Freelancer s : users) {
            // per prendere il numero di skills
            // sumskills += s.getSkills().length;
            // calcolo della varianza
            k = s.getSkills().length - skillAverage(users);
            g += k*k;
        }
        return (g/users.size());
    }
    
}
