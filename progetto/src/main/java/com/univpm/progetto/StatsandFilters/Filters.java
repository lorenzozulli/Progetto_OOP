package com.univpm.progetto.StatsandFilters;

/**
 * Classe che ci permette di accedere ai filtri 
 * @author Lorenzo Zulli, Giovanni Prati
 */

public class Filters {
    /**
	 * Algoritmo che prendere il vettore di users con la skill Java e li ordina, attraverso un quicksort per feedback minimo
	 * @param users
	 */
	public void ordinoPerFeedback(Vector<Freelancer> users,int lowIndex,int highIndex) {
		if (lowIndex >= highIndex) return; //se abbiamo a che fare con un vettore unitario o abbiamo terminato
		int pivotIndex = highindex/2;
		long pivotValue = users.get(pivotIndex).getFeedback();
		swap(users,pivotIndex,highIndex);
		
		int leftPointer = partizionamento(users,lowIndex,highIndex,pivotValue);
		
	    ordinoPerFeedback(users,lowIndex,leftPointer - 1);
	    ordinoPerFeedback(users,leftPointer + 1,highIndex);
    }
	
	@overloading
	public void ordinoPerFeedback(Vector<Freelancer> users) {
		ordinoPerFeedback(users,0,users.size()-1);
	}
	
	public int partizionamento(Vector<Freelancer> users,int lowIndex,int highIndex,long pivotValue) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while (leftPointer < rightPointer) {

	        // vado avanti da sinistra fino a quando non trovo un valore di feedback più grande del pivotValue o arrivo al rightPointer
	        while (users.get(leftPointer).getFeedback() <= pivotValue && leftPointer < rightPointer) {
	          leftPointer++;
	        }
	        // vado avanti da destra fino a quando non trovo un valore di feedback più piccolo del pivotValue o arrivo al leftPointer
	        while (users.get(rightPointer).getFeedback() >= pivotValue && leftPointer < rightPointer) {
	          rightPointer--;
	        }

	        swap(users, leftPointer, rightPointer);
	      }
        //controllo l'ultimo valore
        if(users.get(leftPointer).getFeedback()> users.get(highIndex).getFeedback()) {
            swap(users,leftPointer,highIndex);
          }
          else {
            leftPointer = highIndex;
          }
          return leftPointer;		
    }
	/**
	 * Classe per scambiare due Freelancers
	 * @param users
	 * @param index1
	 * @param index2
	 */	
	public void swap(Vector<Freelancer> users, int index1, int index2) {
		Freelancer temp = new Freelancer();
	    temp.copia(users.get(index1));
	    users.set(index1,users.get(index2));
	    users.set(index2,temp);
	}
}
