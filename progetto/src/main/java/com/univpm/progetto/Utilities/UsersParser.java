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
//import java.util.HashMap;

/**
 * Classe per cercare gli users con la skill Java
 * @author Lorenzo Zulli, Giovanni Prati
 */
public class UsersParser extends Parser {
        public UsersParser(String api_key){
            super(api_key);
        }
        // pezzo di codice preso direttamente da Upwork, vediamo cosa dobbiamo farci
        /*Search freelancers = new Search(client);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("q", "Java");

        freelancers.find(params);*/
        
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
         * Metodo per fare il parsing degli utenti con la skill java per poi farci le vere e proprie operazioni
         * @param responsebody
         * @return Vector<Freelancer>
         */
        public static String parser(String responsebody){
            JSONArray freelancers = new JSONArray(responsebody);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
            for(int i=0; i< freelancers.length(); i++){
                JSONObject freelancer = freelancers.getJSONObject(i);

                JSONArray categories2 = freelancer.getJSONArray("categories2");
                String country = freelancer.getString("country");
                String description = freelancer.getString("description");
                long feedback = freelancer.getLong("feedback");
                LocalDate last_activity = freelancer.getDayOfYear("last_activity"); // da fare il parsing della data
                LocalDate member_since = freelancer.getDate("member_since"); // anche qui
                String name = freelancer.getString("name");
                int portfolio_items_count = freelancer.getInt("portfolio_items_count");
                String portrait_50 = freelancer.getString("portrait_50");
                String profile_type = freelancer.getString("profile_type");
                float rate = freelancer.getFloat("rate");
                JSONArray skills_array = freelancer.getJSONArray("skills");
                int test_passed_count = freelancer.getInt("test_passed_count");
                String title = freelancer.getString("title");

                int skills_count = skills_array.length(); 
                //System.out.println(feedback +" "+ portfolio_items_count +" "+ skills_count);        
            }
            return null;
        }

        /**
         * Metodo per generare l'URL desiderato
         * @return
         */
        public String URLGenerator(){
            String URL = "https://upwork.com/api"; // entry point della documentazione
            URL += ("&appid=" + super.getApi_key());
            // inserire tutto il resto del URL
            return URL;
        }
        // link per prendere la gente con la skill java
        // https://www.upwork.com/api/profiles/v2/search/jobs.json?q=java&callback=?&oauth_params=xxxxx
}

