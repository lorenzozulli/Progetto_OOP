package com.univpm.progetto.TestUtilities;

import static org.junit.jupiter.api.Assertions.*;

import com.univpm.progetto.Utilities.FreelancersParser;
import com.univpm.progetto.Exceptions.MyFileNotFoundException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Services.UpworkService;

//import org.junit.gen5.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;
/**
 * Classe di test per il parsing dei freelancers
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

class TestFreelancersParser {
    FreelancersParser test = new FreelancersParser();
    Freelancer f = new Freelancer();
    UpworkService us = new UpworkService();

    @Test
    void testParser() throws MyFileNotFoundException{
            Vector<Freelancer> users = test.parser();
            Boolean output=false;
        	if(users.get(0).getName().equals("Cristina Vallese"))
        		output = true;
        	
            assertEquals(true, output);
    }
    
}
