package com.univpm.progetto.Utilities;
import com.Upwork.api.Routers.Freelancers.Search;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;

/**
 * Classe per cercare gli users con la skill Java
 * @author Lorenzo Zulli, Giovanni Prati
 */
public class UsersParser extends Parser {
        public UsersParser(String api_key){
            super(api_key);
        }
        // 14 - 19 pezzo di codice preso direttamente da Upwork, vediamo cosa dobbiamo farci
        Search freelancers = new Search(client);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("q", "Java");

        freelancers.find(params);
        /**
         * Metodo per generare l'URL desiderato
         * @return
         */
        public String URLGenerator(){
            String URL = "https://api.upwork.com";
            //da inserire tutto il resto dell'URL
        }
    
}

