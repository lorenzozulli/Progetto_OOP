package com.univpm.progetto.TestStatsandFilters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.StatsandFilters.Filters;
/**
 * Classe di test per i filtri
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class TestFilters {
	Filters test = new Filters();
	Vector<Freelancer> users = new Vector<Freelancer>();
	Freelancer freelancer0 = new Freelancer();
	Freelancer freelancer1= new Freelancer();
	Freelancer freelancer2 = new Freelancer();
	
	double feedback0 = 4.8424790960452;
	double feedback1 = 4.5648729578682;
	double feedback2 = 3.9923456684902;
	
	int dimensionePortfolio0 = 69;
	int dimensionePortfolio1 = 23;
	int dimensionePortfolio2 = 65;
	
	@AfterEach
	void tearDown() throws Exception{
		freelancer0 = null;
		freelancer1 = null;
		freelancer2 = null;
		assertNull(freelancer0);
		assertNull(freelancer1);
		assertNull(freelancer2);
	}
	
	@Test
	void test_ordinoPerFeedback() {
		freelancer0.setFeedback(feedback0);
		freelancer1.setFeedback(feedback1);
		freelancer2.setFeedback(feedback2);
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

        test.ordinoPerFeedback(users);
        boolean output = false;
        output = ((users.get(0).getFeedback() == 3.9923456684902) &&
        		  (users.get(1).getFeedback() == 4.5648729578682) &&
        		  (users.get(2).getFeedback() == 4.8424790960452));

		assertEquals(true,output);		
	}
	@Test
	void test_ordinoPerDimensionePortfolio() {
		freelancer0.setPortfolio_items_count(dimensionePortfolio0);
		freelancer1.setPortfolio_items_count(dimensionePortfolio1);
		freelancer2.setPortfolio_items_count(dimensionePortfolio2);
        users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

        test.ordinoPerDimensionePortfolio(users);
        boolean output = false;
        output = ((users.get(0).getPortfolio_items_count() == 23) &&
        		  (users.get(1).getPortfolio_items_count() == 65) &&
        		  (users.get(2).getPortfolio_items_count() == 69));

		assertEquals(true,output);		
	}
	
	
	
	
	
	
	
	
	
}
