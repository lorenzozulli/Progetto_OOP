package com.univpm.progetto.StatsandFilters;

import com.univpm.progetto.Models.Freelancer;

import java.util.Vector;

/**
 * Classe per ottenere le statistiche legate agli utenti
 * @author Lorenzo Zulli, Giovanni Prati
 */

public class Stats {
    /**
     * Metodo per ottenere la media di progetti nel portfolio degli utenti con la skill "Java"
     * @return Media del numero di progetti nel portfolio
     */
    public double portfolioAverage(Vector<Freelancer> users){
        double sumportfolioitems = 0;
        for(Freelancer s : users)
            sumportfolioitems += s.getPortfolio_items_count();
        return (sumportfolioitems/users.size());
    }
    /**
     * Metodo per ottenere la varianza di progetti nel portfolio degli utenti con la skill "Java"
     * @return Varianza del numero di progetti nel portfolrio
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
     * Metodo per ottenere la media del numero di skill degli utenti con la skill "Java"
     * @return Media del numero di skill
     */
    public double skillAverage(Vector<Freelancer> users){
        double sumskills = 0;
        String[] skillsperfreelancer;
        for (Freelancer s : users){
            skillsperfreelancer = s.getSkills();
            sumskills += skillsperfreelancer.length;
        }
        return (sumskills/users.size());
    }
    /**
     * Metodo per ottenere la varianza di numero di skill degli utenti con la skill "Java"
     * @return Varianza del numero di skill
     */
    public double skillVariance(Vector<Freelancer> users){
        double k, g=0, sumskills = 0;
        String[] skillsperfreelancer;
        for (Freelancer s : users) {
            // per prendere il numero di skills
            skillsperfreelancer = s.getSkills();
            sumskills += skillsperfreelancer.length;
            // calcolo della varianza
            k = sumskills - skillAverage(users);
            g += k*k;
        }
        return (g/users.size());
    }
    
}
