package com.univpm.progetto.TestStatsandFilters;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

import org.junit.gen5.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.StatsandFilters.Filters;

class TestFilters {

    Filters test = new Filters();
    private Freelancer freelancer0;
    private Freelancer freelancer1;
    private Freelancer freelancer2;

	@BeforeEach
	void setUp() throws Exception{

		Freelancer freelancer0 = new Freelancer();
		Freelancer freelancer1= new Freelancer();
		Freelancer freelancer2 = new Freelancer();

		freelancer0.setPortfolio_items_count(5);
		freelancer1.setPortfolio_items_count(30);
		freelancer2.setPortfolio_items_count(25);

        freelancer0.setFeedback(3.9000);
        freelancer1.setFeedback(2.4566);
        freelancer2.setFeedback(3.1415);
	}

    @AfterEach
    void tearDown() throws Exception{
    }

	@Test
	void testOrdinoPerFeedback() {
        Vector<Freelancer> users = new Vector<Freelancer>();
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

        assertThat(this.testOrdinoPerFeedback(), contains(2.4566, 3.1415, 3.900));
	}
    @Test
    void testOrdinoPerDimensionePortfolio(){
        Vector<Freelancer> users = new Vector<Freelancer>();
		users.add(freelancer0);
		users.add(freelancer1);
		users.add(freelancer2);

		boolean output = test.ordinoPerDimensionePortfolio(users);
		assertEquals(20,output);
    }

}
