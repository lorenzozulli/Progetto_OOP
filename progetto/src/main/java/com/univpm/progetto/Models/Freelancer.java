package com.univpm.progetto.Models;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.JSONObject;

/**
 * Classe che modella il Freelancer
 * @author Lorenzo Zulli
 * @author Giovanni Prati
 */

public class Freelancer {
    private String[] categories2;
    private String country;
    private String description;
    private double feedback;
    private String id;
    private String last_activity; // usiamo string in quanto non dobbiamo farci operazioni
    private String member_since; // usiamo string in quanto non dobbiamo farci operazioni
    private String name;
    private int portfolio_items_count;
    private String portrait_50;
    private String profile_type;
    private float rate;
    private String[] skills;
    private int test_passed_count;
    private String title;
    /**
     * Costruttore del Freelancer
     * @param categories2 Elenco delle categorie (JSON array)
     * @param country Nazionalità
     * @param description Descrizione
     * @param feedback Numero per indicare il feedback
     * @param id Codice identificativo
     * @param last_activity Data dell' ultima attività (ISO 8601)
     * @param member_since Data di iscrizione ad Upwork (ISO 8601)
     * @param name Il suo nome
     * @param portfolio_items_count Numero di oggetti nel portfolio
     * @param portrait_50
     * @param profile_type Indica il tipo di profilo (Agency, Independent)
     * @param rate Numero usato per filtrare le ricerche dal profilo (//da chiarire un attimo)
     * @param skills Elenco delle skills (JSON array)
     * @param test_passed_count Numero di test passati 
     * @param title Titolo del profilo del freelancer
     */
    public Freelancer(String[] categories2, String country, String description, double feedback,
                      String id, String last_activity, String member_since, String name,
                      int portfolio_items_count, String portrait_50, String profile_type, float rate,
                      String[] skills, int test_passed_count, String title){
        this.categories2 = categories2;
        this.country = country;
        this.description = description;
        this.feedback = feedback;
        this.id = id;
        this.last_activity = last_activity;
        this.member_since = member_since;
        this.name = name;
        this.portfolio_items_count = portfolio_items_count;
        this.portrait_50 = portrait_50;
        this.profile_type = profile_type;
        this.rate = rate;
        this.skills = skills;
        this.test_passed_count = test_passed_count;
        this.title = title;       
    }
    
    /**
     * Costruttore vuoto per il metodo di swap per i filters
     */
    public Freelancer(){

    }
        
    /** 
     * Metodo di supporto per "swap"
     * @param daCopiare
     */
    public void copia(Freelancer daCopiare) {
    	this.categories2 = daCopiare.getCategories2();
        this.country = daCopiare.getCountry();
        this.description = daCopiare.getDescription();
        this.feedback = daCopiare.getFeedback();
        this.id = daCopiare.getId();
        this.last_activity = daCopiare.getLast_activity();
        this.member_since = daCopiare.getMember_since();
        this.name = daCopiare.getName();
        this.portfolio_items_count = daCopiare.getPortfolio_items_count();
        this.portrait_50 = daCopiare.getPortrait_50();
        this.profile_type = daCopiare.getProfile_type();
        this.rate = daCopiare.getRate();
        this.skills = daCopiare.getSkills();
        this.test_passed_count = daCopiare.getTest_passed_count();
        this.title = daCopiare.getTitle();    
    }
   
    /**
     * Getter per categories2
     * @return categories2
     */
    public String[] getCategories2() {
        return categories2;
    }

    /**
     * Setter per categories2
     * @param categories2
     */
    public void setCategories2(String[] categories2) {
        this.categories2 = categories2;
    }

    /**
     * Getter per country
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter per country
     * @param country 
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter per description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter per description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter per feedback
     * @return feedback
     */
    public double getFeedback() {
        return feedback;
    }

    /**
     * Setter per feedback
     * @param feedback 
     */
    public void setFeedback(double feedback) {
        this.feedback = feedback;
    }

    /**
     * Getter per id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter per id
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter per last_activity
     * @return last_activity
     */
    public String getLast_activity() {
        return last_activity;
    }

    /**
     * Setter per last_activity
     * @param last_activity
     */
    public void setLast_activity(String last_activity) {
        this.last_activity = last_activity;
    }

    /**
     * Getter per member_since
     * @return member_since
     */
    public String getMember_since() {
        return member_since;
    }

    /**
     * Setter per member_since
     * @param member_since 
     */
    public void setMember_since(String member_since) {
        this.member_since = member_since;
    }

    /**
     * Getter per name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter per name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter per portfolio_items_count
     * @return portfolio_items_count
     */
    public int getPortfolio_items_count() {
        return portfolio_items_count;
    }

    /**
     * Setter per portfolio_items_count
     * @param portfolio_items_count
     */
    public void setPortfolio_items_count(int portfolio_items_count) {
        this.portfolio_items_count = portfolio_items_count;
    }

    /**
     * Getter per portrait_50
     * @return portrait_50
     */
    public String getPortrait_50() {
        return portrait_50;
    }

    /**
     * Setter per portrait_50
     * @param portrait_50
     */
    public void setPortrait_50(String portrait_50) {
        this.portrait_50 = portrait_50;
    }

    /**
     * Getter per profile_type
     * @return profile_type
     */
    public String getProfile_type() {
        return profile_type;
    }

    /**
     * Setter per profile_type
     * @param profile_type
     */
    public void setProfile_type(String profile_type) {
        this.profile_type = profile_type;
    }

    /**
     * Getter per rate
     * @return rate
     */
    public float getRate() {
        return rate;
    }

    /**
     * Setter per rate
     * @param rate
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    /**
     * Getter per skills
     * @return skills
     */
    public String[] getSkills() {
        return this.skills;
    }

    /**
     * Setter per skills
     * @param skills
     */
    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    /**
     * Getter per test_passed_count
     * @return test_passed_count
     */
    public int getTest_passed_count() {
        return test_passed_count;
    }

    /**
     * Setter per test_passed_count
     * @param test_passed_count 
     */
    public void setTest_passed_count(int test_passed_count) {
        this.test_passed_count = test_passed_count;
    }

    /**
     * Getter per title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter per title
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Metodo toJSONObject
     * @return object
     */
    public JSONObject toJSONObject(){
        JSONObject object = new JSONObject();
        JSONArray arraycategories2 = new JSONArray();
        JSONArray arrayskills = new JSONArray();

        for(int i=0; i<this.categories2.length;i++){
            arraycategories2.add(this.categories2[i]);
        }
        object.put("categories2", arraycategories2);
        object.put("country", this.country);
        object.put("description", this.description);
        object.put("feedback", this.feedback);
        object.put("id", this.id);
        object.put("last_activity", this.last_activity);
        object.put("member_since", this.member_since);
        object.put("name", this.name);
        object.put("portfolio_items_count", this.portfolio_items_count);
        object.put("portrait_50", this.portrait_50);
        object.put("profile_type", this.profile_type);
        object.put("rate", this.rate);
        for(int i=0; i<this.skills.length;i++){
            arrayskills.add(this.skills[i]);
        }
        object.put("skills", arrayskills);
        object.put("test_passed_count", this.test_passed_count);
        object.put("title", this.title);
        return object;
    }

    private Vector<Freelancer> freelancers = new Vector<Freelancer>();


    /**
     * Getter per Freelancers
     * @return freelancers
     */
    public Vector<Freelancer> getFreelancers() {
        return freelancers;
    }

    /**
     * Setter per Freelancers
     * @param freelancers 
     */
    public void setFreelancers(Vector<Freelancer> freelancers) {
        this.freelancers = freelancers;
    }

}
