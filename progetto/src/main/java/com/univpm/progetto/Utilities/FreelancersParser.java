package com.univpm.progetto.Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Vector;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.univpm.progetto.Models.Freelancer;

/**
 * Classe che effettua la richiesta HTTP(nel nostro caso simulata attraverso il file JSON) e fa il parsing
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */
public class FreelancersParser {
    /**
     * Metodo per effettuare il parsing dei Freelancers
     * 
     * @param responsebody
     * @return f
     */
    public Vector<Freelancer> parser() {
        JSONParser parser = new JSONParser();
        Vector<Freelancer> f = new Vector<Freelancer>();
        File file = new File("DB.json");

        try (FileReader reader = new FileReader(file)) {
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
                boolean javacheck = false;
                    for (int k = 0; k < numeroSkills; k++) {
                        skills[k] = (String) jsonArray_skills.get(k);
                        if (skills[k].equals("java"))
                            javacheck = true;
                    }
                    if(!javacheck)
                     continue;

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
}
