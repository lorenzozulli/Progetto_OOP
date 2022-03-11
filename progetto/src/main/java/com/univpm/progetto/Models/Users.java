package com.univpm.progetto.Models;

import java.util.Vector;

public class Users {
	private static int numeroFreelancer=0;
    static Vector<Freelancer> usersVector = new Vector<Freelancer>();

    public static void addFreelancer(Freelancer toAdd) {
    	usersVector.add(toAdd);
    	setNumeroFreelancer(numeroFreelancer+1);
    }
   
    public int getNumeroFreelancer() {
        return numeroFreelancer;
    }
    
    public static void setNumeroFreelancer(int numeroFreelancer_) {
        numeroFreelancer = numeroFreelancer_;
    }

    	
}
