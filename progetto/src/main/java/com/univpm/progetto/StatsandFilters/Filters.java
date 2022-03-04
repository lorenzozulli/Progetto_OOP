package com.univpm.progetto.StatsandFilters;

public class Filters {
    
	public void ordinoPerFeedback(Vector<Freelancer> users) {
		int lowIndex = 0;
		int highIndex = users.size()-1;
		if (lowIndex >= highIndex) return; //se abbiamo a che fare con un vettore unitario o abbiamo terminato
		int pivotIndex = highindex/2;
		long pivot = users.get(pivotIndex).getFeedback();
		
		long valoreSx = users.get(lowIndex).getFeedback();
		long valoreDx = users.get(highIndex).getFeedback();

	    while (valoreSx < valoreDx) {

	      
	    }
		
		
		
	}
	
	public void swap(Vector<Freelancer> users, int index1, int index2) {
		Freelancer temp = new Freelancer();
	    temp = users.get(index1);
	    users.set(index1,users.get(index2));
	    users.set(index2,temp);
	  }
}
