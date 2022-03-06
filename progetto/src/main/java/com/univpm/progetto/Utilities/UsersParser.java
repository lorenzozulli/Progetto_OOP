package com.univpm.progetto.Utilities;
import com.Upwork.api.Routers.Freelancers.Search;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.HashMap;

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
         * @return 
         */
        public static String parser(String responsebody){
            JSONArray albums = new JSONArray(responsebody);
            for(int i=0; i< /*dimensione*/; i++){
                JSONObject album = albums.getJSONObject(i); //da metterci quello nostro di Upwork mi raccomando
                double feedback = album.getDouble("feedback");
                int portfolio_items_count = album.getInt("portfolio_items_count");
                //inserire parte per le skill           
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
        }
    
}

