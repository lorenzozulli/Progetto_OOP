package com.univpm.progetto.Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.univpm.progetto.Models.Freelancer;

import org.json.JSONArray;

public class JsonReader {
	JSONArray users = new JSONArray();
	public String fileName = "DB.json";
	
    // Empty Constructor 
	JsonReader(){
		
	}
	
	public void readJson() throws ParseException {
		JSONParser jsonParser = new JSONParser();  //creo il parser
		try(FileReader reader = new FileReader(fileName)){  //vado a leggere il file
			Object object = jsonParser.parse(fileName);  //in object metto il parse di ciò che ho letto
			JSONArray users =(JSONArray) object;
			users.forEach(empty->parseEmpObject((JSONObject)empty));//per ogni object contenuto nell'array users, vado a fare il parse campo per campo
		}catch (FileNotFoundException e) {
		   System.out.println("File non trovato");
		}catch (IOException e) {
		   System.out.println("Errore IO");}
			
	 } 
	}



	

}
