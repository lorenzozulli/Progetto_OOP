package com.univpm.progetto.TestException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.univpm.progetto.Exceptions.MyFileNotFoundException;
import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Utilities.FreelancersParser;
/**
 * Classe che testa l'eccezione MyFileNotFound
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class TestMyFileNotFoundExc {
	MyFileNotFoundException e;
    FreelancersParser test = new FreelancersParser();
    @BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
    @Test
    void testMyFileNotFoundException(){
    	e = assertThrows(MyFileNotFoundException.class, () -> {
            @SuppressWarnings("unused")
			Vector<Freelancer> users = test.parser();
			});
            assertEquals("ERRORE: non e' stato possibile trovare il file!", e.getOutput());
    }
    


}
