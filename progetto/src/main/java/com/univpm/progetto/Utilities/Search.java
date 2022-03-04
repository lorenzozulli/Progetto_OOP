package com.univpm.progetto.Utilities;
import com.Upwork.api.Routers.Freelancers.Search;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;

/**
 * Classe per cercare gli users
 * @author Lorenzo Zulli, Giovanni Prati
 */
public class Search {
    @GetMapping("/search/")
    public void searcher(){
        Search freelancers = new Search(client);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("q", "Java");

        freelancers.find(params);
    }
    
}

