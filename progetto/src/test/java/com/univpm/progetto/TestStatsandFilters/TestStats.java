package com.univpm.progetto.TestStatsandFilters;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

import org.junit.gen5.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.StatsandFilters.Stats;

class TestStats {
	@BeforeEach
	void setUp(){
		Stats test = new Stats();
		Vector<Freelancer> users = new Vector<Freelancer>();
		
		Freelancer freelancer0 = new Freelancer();
		Freelancer freelancer1= new Freelancer();
		Freelancer freelancer2 = new Freelancer();

		freelancer0.setPortfolio_items_count(5);
		freelancer1.setPortfolio_items_count(30);
		freelancer2.setPortfolio_items_count(25);

	}

	@Test
	void test() {
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

		double output = test.portfolioAverage(users);
		assertEquals(20,output);
		
	}

}
