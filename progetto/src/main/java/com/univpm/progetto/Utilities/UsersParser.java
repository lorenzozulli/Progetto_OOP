package com.univpm.progetto.Utilities;
//import com.Upwork.api.Routers.Freelancers.Search;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.net.URI;

import com.univpm.progetto.Models.*;
import java.util.Vector;

/**
 * Classe per cercare gli users con la skill Java
 * @author Lorenzo Zulli, Giovanni Prati
 */
public class UsersParser extends Parser {
        public UsersParser(String api_key){
            super(api_key);
        }
        
        /**
         * Metodo per effettuare la richiesta HTTP
         */
        public void usersRequest(){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.URLGenerator())).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(UsersParser::parser)
                    .join();
        }
        /**
         * Metodo per effettuare il parsing degli utenti con la skill java per poi farci le vere e proprie operazioni
         * @param responsebody
         * @return f (come vettore di Freelancers)
         */
        public static Vector<Freelancer> parser(String responsebody){
            JSONArray freelancers = new JSONArray(responsebody);
            Vector<Freelancer> f = new Vector<Freelancer>();
            for(int i=0; i< freelancers.length(); i++){
                JSONObject freelancer = freelancers.getJSONObject(i);
                
               JSONArray jsonArray_categories2 = (JSONArray) freelancer.get("categories2");
             int numeroCategories2 = jsonArray_categories2.length();
        	 String[] categories2 = new String[numeroCategories2];

			 for(int k=0; k < numeroCategories2; k++) {
			   categories2[k]=(String) jsonArray_categories2.get(k);
			 }
             String country = freelancer.getString("country");
             String description = freelancer.getString("description");
             long feedback = freelancer.getLong("feedback");
             String id = freelancer.getString("id");
             LocalDate last_activity = (LocalDate) freelancer.get("last_activity"); // in type cast per comodita
	     LocalDate member_since = (LocalDate) freelancer.get("member_since"); // inttype cast per comodita
             String name = freelancer.getString("name");
             int portfolio_items_count = freelancer.getInt("portfolio_items_count");
             String portrait_50 = freelancer.getString("portrait_50");
             String profile_type = freelancer.getString("profile_type");
             float rate = freelancer.getFloat("rate");  
             JSONArray jsonArray_skills = (JSONArray) freelancer.get("skills");
             int numeroSkills = jsonArray_skills.length();
        	 String[] skills = new String[numeroSkills];

			 for(int k=0; k < numeroSkills; k++) {
			    skills[k]=(String) jsonArray_skills.get(k);
			 }
             int test_passed_count = freelancer.getInt("test_passed_count");
             String title = freelancer.getString("title");
             
             Freelancer daAggiungere = new Freelancer(categories2, country, description, feedback, id, 
                                                     last_activity, member_since, name, portfolio_items_count,
                                                     portrait_50, profile_type, rate, skills, test_passed_count,
                                                     title);
             f.add(daAggiungere);

             int skills_count = skills.length;                       
         }
            return f;
        }

        /**
         * Metodo per generare l'URL desiderato
         * @return URL (come una stringa)
         */
        public String URLGenerator(){
            String URL = "https://upwork.com/api/profiles/v2/search/"; // entry point della documentazione
            URL += ("jobs.json?q=");
            URL += ("java"); // per cambiare la skill da cercare
            URL += ("&callback=?");
            URL += ("&oauth_params=");
            URL += ("xxxxx"); // per cambiare il parametro di autenticazione
            return URL;
        }
        // link per prendere la gente con la skill java
        // https://www.upwork.com/api/profiles/v2/search/jobs.json?q=java&callback=?&oauth_params=xxxxx
}

