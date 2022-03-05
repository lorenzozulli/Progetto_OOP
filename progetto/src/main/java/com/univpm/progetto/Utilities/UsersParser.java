package com.univpm.progetto.Utilities;
import com.Upwork.api.Routers.Freelancers.Search;
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
        Search freelancers = new Search(client);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("q", "Java");

        freelancers.find(params);
        
        /**
         * Metodo per la richesta degli utenti
         * @return
         */
        public void usersRequest(){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("//inserire il link di upwork")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
        }

        /**
         * Metodo per generare l'URL desiderato
         * @return
         */
        public String URLGenerator(){
            String URL = "https://api.upwork.com";
            //da inserire tutto il resto dell'URL
        }
    
}

