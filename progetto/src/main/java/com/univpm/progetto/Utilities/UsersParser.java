package com.univpm.progetto.Utilities;
//import com.Upwork.api.Routers.Freelancers.Search;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
         * Metodo per la richesta degli utenti
         * @return
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
         * @return null
         */
        public static String parser(String responsebody){
            JSONArray freelancers = new JSONArray(responsebody);
            for(int i=0; i< freelancers.length(); i++){
                JSONObject freelancer = freelancers.getJSONObject(i);
                double feedback = freelancer.getDouble("feedback");
                int portfolio_items_count = freelancer.getInt("portfolio_items_count");
                JSONArray skills_array = freelancer.getJSONArray("skills");
                int skills_count = skills_array.length(); 
                System.out.println(feedback +" "+ portfolio_items_count +" "+ skills_count);        
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
    
}

