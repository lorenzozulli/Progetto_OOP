package com.univpm.progetto.Models;

import java.util.Vector;
/**
 * Classe che descrive un insieme di freelancers
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class Users {
	private static int numFreelancer=0;
    private Vector<Freelancer> freelancers = new Vector<Freelancer>();

    public void addFreelancer(Freelancer toAdd) {
    	freelancers.add(toAdd);
    	setNumeroFreelancer(numFreelancer+1);
    }
   
    public int getNumeroFreelancer() {
        return numFreelancer;
    }
    
    public static void setNumeroFreelancer(int numFreelancer_) {
        numFreelancer = numFreelancer_;
    } 	
}
