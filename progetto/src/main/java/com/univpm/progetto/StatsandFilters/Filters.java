package com.univpm.progetto.StatsandFilters;

import java.util.Vector;

import org.json.JSONArray;
/**
 * Classe che ci permette di accedere ai filtri 
 * @author Lorenzo Zulli, Giovanni Prati
 */

public class Filters {
    /**
	 * Metodo per ordinare gli users con la skill Java per feedback in ordine crescente (quicksort)
	 * @param users
	 */
	public JSONArray ordinoPerFeedback(Vector<Freelancer> users,int lowIndex,int highIndex) {
		if (lowIndex >= highIndex) return null; //se abbiamo a che fare con un vettore unitario o abbiamo terminato
		int pivotIndex = highIndex/2;
		long pivotValue = users.get(pivotIndex).getFeedback();
		swap(users,pivotIndex,highIndex);
		
		int leftPointer = partizionamentoPerFeedback(users,lowIndex,highIndex,pivotValue);
		
	    ordinoPerFeedback(users,lowIndex,leftPointer - 1);
	    ordinoPerFeedback(users,leftPointer + 1,highIndex);
    }
	
	@Overloading
	public void ordinoPerFeedback(Vector<Freelancer> users) {
		ordinoPerFeedback(users,0,users.size()-1);
	}
	/**
	 * Metodo per ordinare gli userso con la skill Java per dimensione del portfolio in ordine crescente (quicksort)
	 * @param users
	 * @param lowIndex
	 * @param highIndex
	 */
	public void ordinoPerDimensionePortfolio(Vector<Freelancer> users,int lowIndex,int highIndex) {
		if (lowIndex >= highIndex) return; //se abbiamo a che fare con un vettore unitario o abbiamo terminato
		int pivotIndex = highIndex/2;
		int pivotValue = users.get(pivotIndex).getPortfolio_items_count();
		swap(users,pivotIndex,highIndex);
		
		int leftPointer = partizionamentoPerDimensionePortfolio(users,lowIndex,highIndex,pivotValue);
		
		ordinoPerDimensionePortfolio(users,lowIndex,leftPointer - 1);
		ordinoPerDimensionePortfolio(users,leftPointer + 1,highIndex);
	}
	
	@OverLoading
	public void ordinoPerDimensionePortfolio(Vector<Freelancer> users) {
		ordinoPerDimensionePortfolio(users,0,users.size()-1);
	}
	
	public int partizionamentoPerFeedback(Vector<Freelancer> users,int lowIndex,int highIndex,long pivotValue) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while (leftPointer < rightPointer) {

	        // vado avanti da sinistra fino a quando non trovo un valore di feedback pi� grande del pivotValue o arrivo al rightPointer
	        while (users.get(leftPointer).getFeedback() <= pivotValue && leftPointer < rightPointer) {
	          leftPointer++;
	        }
	        // vado avanti da destra fino a quando non trovo un valore di feedback pi� piccolo del pivotValue o arrivo al leftPointer
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
	
	public int partizionamentoPerDimensionePortfolio(Vector<Freelancer> users,int lowIndex,int highIndex,int pivotValue) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while (leftPointer < rightPointer) {

	        // vado avanti da sinistra fino a quando non trovo un valore di feedback pi� grande del pivotValue o arrivo al rightPointer
	        while (users.get(leftPointer).getPortfolio_items_count() <= pivotValue && leftPointer < rightPointer) {
	          leftPointer++;
	        }
	        // vado avanti da destra fino a quando non trovo un valore di feedback pi� piccolo del pivotValue o arrivo al leftPointer
	        while (users.get(rightPointer).getPortfolio_items_count() >= pivotValue && leftPointer < rightPointer) {
	          rightPointer--;
	        }

	        swap(users, leftPointer, rightPointer);
	      }
        //controllo l'ultimo valore
        if(users.get(leftPointer).getPortfolio_items_count()> users.get(highIndex).getPortfolio_items_count()) {
            swap(users,leftPointer,highIndex);
          }
          else {
            leftPointer = highIndex;
          }
          return leftPointer;		
    }
	/**
	 * Metodo per scambiare due Freelancers
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
