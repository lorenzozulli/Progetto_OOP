package com.univpm.progetto.TestUtilities;

import static org.junit.jupiter.api.Assertions.*;

import com.univpm.progetto.Utilities.FreelancersParser;
import com.univpm.progetto.Models.Freelancer;

//import org.junit.gen5.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

class TestFreelancersParser {
    FreelancersParser test = new FreelancersParser();
    Freelancer f = new Freelancer();

    @Test
    void testParser(){
        Vector<Freelancer> users = test.parser();
        boolean output=false;
        if(users.get(0).getName().equals("Cristina Vallese"))
            output = true;
        assertEquals(true, output);
    }
    
}
