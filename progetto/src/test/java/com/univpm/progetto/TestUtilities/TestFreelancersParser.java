package com.univpm.progetto.TestUtilities;

import static org.junit.jupiter.api.Assertions.*;

import com.univpm.progetto.Utilities.FreelancersParser;
import com.univpm.progetto.Exceptions.MyFileNotFoundException;
import com.univpm.progetto.Models.Freelancer;

//import org.junit.gen5.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

class TestFreelancersParser {
    FreelancersParser test = new FreelancersParser();
    Freelancer f = new Freelancer();

    @Test
    void testParser() throws MyFileNotFoundException {
            boolean output=false;
            Vector<Freelancer> users = test.parser();
            if(users.get(0).getName().equals("Cristin0 Vallese"))
            output = true;
            assertEquals(true, output);
    }
    
}
