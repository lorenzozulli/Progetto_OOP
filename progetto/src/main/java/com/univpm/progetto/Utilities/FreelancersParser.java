package com.univpm.progetto.Utilities;
//import com.Upwork.api.Routers.Freelancers.Search;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Vector;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

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
public class FreelancersParser {
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
    public Vector<Freelancer> parser() {
        JSONParser parser = new JSONParser();
        Vector<Freelancer> f = new Vector<Freelancer>();
        try (FileReader reader = new FileReader("DB.json")) {
            JSONArray freelancers = (JSONArray) parser.parse(reader);
            for (int i = 0; i < freelancers.size(); i++) {
                JSONObject freelancer = (JSONObject) freelancers.get(i);

                JSONArray jsonArray_categories2 = (JSONArray) freelancer.get("categories2");
                int numeroCategories2 = jsonArray_categories2.size();
                String[] categories2 = new String[numeroCategories2];
                    for (int k = 0; k < numeroCategories2; k++) {
                        categories2[k] = (String) jsonArray_categories2.get(k);
                    }

                String country = (String) freelancer.get("country");
                String description = (String) freelancer.get("description");
                double feedback = Double.parseDouble((String) freelancer.get("feedback"));
                String id = (String) freelancer.get("id");
                String last_activity = (String) freelancer.get("last_activity"); //String visto che tanto non dobbiamo farci operazioni
                String member_since = (String) freelancer.get("member_since"); //String visto che tanto non dobbiamo farci operazioni
                String name = (String) freelancer.get("name");
                int portfolio_items_count = Integer.parseInt((String) freelancer.get("portfolio_items_count"));
                String portrait_50 = (String)freelancer.get("portrait_50");
                String profile_type = (String)freelancer.get("profile_type");
                float rate = Float.parseFloat((String) freelancer.get("rate"));

                JSONArray jsonArray_skills = (JSONArray) freelancer.get("skills");
                int numeroSkills = jsonArray_skills.size();
                String[] skills = new String[numeroSkills];
                    for (int k = 0; k < numeroSkills; k++) {
                        skills[k] = (String) jsonArray_skills.get(k);
                    }

                int test_passed_count = Integer.parseInt((String) freelancer.get("test_passed_count")); 
                String title = (String) freelancer.get("title");

                Freelancer daAggiungere = new Freelancer(categories2, country, description, feedback, id,
                        last_activity, member_since, name, portfolio_items_count,
                        portrait_50, profile_type, rate, skills, test_passed_count,
                        title);
                f.add(daAggiungere);
        }           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
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
