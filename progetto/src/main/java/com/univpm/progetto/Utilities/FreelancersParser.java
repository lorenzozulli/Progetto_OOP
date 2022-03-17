package com.univpm.progetto.Utilities;
//import com.Upwork.api.Routers.Freelancers.Search;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Vector;
import java.time.LocalDate;

/*
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
*/

import com.univpm.progetto.Models.Freelancer;

/**
 * Classe che effettua la richiesta HTTP e fa il parsing
 * 
 * @author Lorenzo Zulli, Giovanni Prati
 */
public class FreelancersParser extends Parser {
    /**
     * Costruttore del Freelancers Parser
     * @param api_key
     */
    public FreelancersParser(String api_key) {
        super(api_key);
    }
    /*
    public void FreelancersRequest() {
        HttpClient client = HttpClient.newHttpClient(); // creo il client
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.URLGenerator())).build(); // creo la richesta con il link di URLGenerator
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()) // richiesta asincrona al client
                .thenApply(HttpResponse::body) // applica la risposta al body
                .thenApply(FreelancersParser::parser) // parsing del conenuto
                .thenAccept(System.out::println)
                .join();
    }*/

    /**
     * Metodo per effettuare il parsing dei Freelancers
     * 
     * @param responsebody
     * @return f
     */
    public static Vector<Freelancer> parser(String responsebody) {
        JSONArray freelancers = new JSONArray(responsebody);
        Vector<Freelancer> f = new Vector<Freelancer>();
        for (int i = 0; i < freelancers.length(); i++) {
            JSONObject freelancer = freelancers.getJSONObject(i);

            JSONArray jsonArray_categories2 = (JSONArray) freelancer.get("categories2");
            int numeroCategories2 = jsonArray_categories2.length();
            String[] categories2 = new String[numeroCategories2];

            for (int k = 0; k < numeroCategories2; k++) {
                categories2[k] = (String) jsonArray_categories2.get(k);
            }
            String country = freelancer.getString("country");
            String description = freelancer.getString("description");
            long feedback = freelancer.getLong("feedback");
            String id = freelancer.getString("id");
            LocalDate last_activity = (LocalDate) freelancer.get("last_activity"); // in type cast per comodita
            LocalDate member_since = (LocalDate) freelancer.get("member_since"); // in type cast per comodita
            String name = freelancer.getString("name");
            int portfolio_items_count = freelancer.getInt("portfolio_items_count");
            String portrait_50 = freelancer.getString("portrait_50");
            String profile_type = freelancer.getString("profile_type");
            float rate = freelancer.getFloat("rate");
            JSONArray jsonArray_skills = (JSONArray) freelancer.get("skills");
            int numeroSkills = jsonArray_skills.length();
            String[] skills = new String[numeroSkills];

            for (int k = 0; k < numeroSkills; k++) {
                skills[k] = (String) jsonArray_skills.get(k);
            }
            int test_passed_count = freelancer.getInt("test_passed_count");
            String title = freelancer.getString("title");

            Freelancer daAggiungere = new Freelancer(categories2, country, description, feedback, id,
                    last_activity, member_since, name, portfolio_items_count,
                    portrait_50, profile_type, rate, skills, test_passed_count,
                    title);
            f.add(daAggiungere);
        }
        return f;
    }

    /**
     * Metodo per generare l'URL desiderato
     * 
     * @return URL
     */
    /*
    public String URLGenerator() {
        String URL = "https://upwork.com/api/profiles/v2/search/"; // entry point della documentazione
        URL += ("jobs.json?q=");
        URL += ("java"); // per cambiare la skill da cercare
        URL += ("&callback=?");
        URL += ("&oauth_params=");
        URL += ("xxxxx"); // per cambiare il parametro di autenticazione
        return URL;
    }*/
    // link per prendere la gente con la skill java
    // https://www.upwork.com/api/profiles/v2/search/jobs.json?q=java&callback=?&oauth_params=xxxxx
}
