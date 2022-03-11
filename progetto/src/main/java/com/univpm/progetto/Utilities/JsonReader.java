package com.univpm.progetto.Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.univpm.progetto.Models.Freelancer;
import com.univpm.progetto.Models.Users;

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

	public void parseEmpObject(JSONObject empty) { //metodo che legge le informazioni del json e le assegna ad un freelancer, che verrà poi aggiunto al vettore di freelancer
		Freelancer daAggiungere = new Freelancer();
		JSONObject full=(JSONObject)empty.get(null);
		//prendo categories2 dal json e lo metto nel freelancer daAggiungere
		JSONArray categories2 = (JSONArray)full.get("categories2");
		Iterator<Object> iterator = categories2.iterator();
		int n = 0;
		String[] categories2__= new String[3];
		while(iterator.hasNext()) {
            categories2__[n] = (String) iterator.next();
            n++;
		}
		daAggiungere.setCategories2(categories2__);
		//prendo country dal json e lo metto nel freelancer daAggiungere
		String country = (String) full.get("country");
		daAggiungere.setCountry(country);
		//prendo description dal json e lo metto nel freelancer daAggiungere
		String description = (String) full.get("description");
		daAggiungere.setDescription(description);
		//prendo feedback dal json e lo metto nel freelancer daAggiungere
		long feedback = (long) full.get("feedback");
		daAggiungere.setFeedback(feedback);
		//prendo id dal json e lo metto nel freelancer daAggiungere
		String id = (String) full.get("id");
		daAggiungere.setId(id);
		//prendo last_activity dal json e lo metto nel freelancer daAggiungere
		LocalDate last_activity = (LocalDate) full.get("last_activity");
		daAggiungere.setLast_activity(last_activity);
		//prendo member_since dal json e lo metto nel freelancer daAggiungere
		LocalDate member_since = (LocalDate) full.get("member_since");
		daAggiungere.setMember_since(member_since);
		//prendo name dal json e lo metto nel freelancer daAggiungere
		String name = (String) full.get("name");
		daAggiungere.setName(name);
		//prendo portfolio_items_count dal json e lo metto nel freelancer daAggiungere
		int portfolio_items_count = (int) full.get("portfolio_items_count");
		daAggiungere.setPortfolio_items_count(portfolio_items_count);
		//prendo portrait_50 dal json e lo metto nel freelancer daAggiungere
		String portrait_50 = (String) full.get("portrait_50");
		daAggiungere.setPortrait_50(portrait_50);
		//prendo profile_type dal json e lo metto nel freelancer daAggiungere
		String profile_type = (String) full.get("profile_type");
		daAggiungere.setProfile_type(profile_type);
		//prendo rate dal json e lo metto nel freelancer daAggiungere
		float rate = (float) full.get("rate");
		daAggiungere.setRate(rate);
		//prendo skills dal json e lo metto nel freelancer daAggiungere
		JSONArray skills = (JSONArray)full.get("skills");
		iterator = skills.iterator();
		int k = 0;
		String[] skills_= new String[7];
		while(iterator.hasNext()) {
			skills_[k] = (String) iterator.next();
            k++;
		}
		daAggiungere.setSkills(skills_);
		//prendo test_passed_count dal json e lo metto nel freelancer daAggiungere
		int test_passed_count = (int) full.get("test_passed_count");
		daAggiungere.setTest_passed_count(test_passed_count);
		//prendo title dal json e lo metto nel freelancer daAggiungere
		String title = (String) full.get("title");
		daAggiungere.setTitle(title);
		Users.addFreelancer(daAggiungere);//aggiungo il freelancer al vettore Users
		
	}



	

}
