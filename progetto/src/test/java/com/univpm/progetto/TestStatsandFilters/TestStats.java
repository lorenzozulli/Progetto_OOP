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
		
		String[] skills0 = {"java",
				"una_skill",
				"una_skill",
	            "una_skill",
	            "una_skill",
	            "una_skill"};
		String[] skills1 = {"java",
				"una_skill",
				"una_skill",
	            "una_skill",
	            "una_skill",
	            "una_skill"};
		String[] skills2 = {"java",
				"una_skill",
				"una_skill"};

		freelancer0.setSkills(skills0);
		freelancer1.setSkills(skills1);
		freelancer2.setSkills(skills2);

		

	}

	@Test
	void test_portfolioAverage() {
		freelancer0.setPortfolio_items_count(5);
		freelancer1.setPortfolio_items_count(30);
		freelancer2.setPortfolio_items_count(25);
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

		double output = test.portfolioAverage(users);
		assertEquals(20,output);
		
	}
	@Test
	void test_portfolioVariance() {
		freelancer0.setPortfolio_items_count(5);
		freelancer1.setPortfolio_items_count(15);
		freelancer2.setPortfolio_items_count(25);
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

		double output = test.portfolioVariance(users);
		assertEquals(100,output);
		
	}
	
	@Test
	void test_skillAverage() {
		
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

		double output = test.skillAverage(users);
		assertEquals(5,output);
		
	}
	
	@Test
	void test_skillVariance() {
		
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

		double output = test.skillVariance(users);
		assertEquals(3,output);
		
	}
}
