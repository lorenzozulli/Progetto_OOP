package com.univpm.progetto.Models;

import java.time.LocalDate;
/**
 * Classe che modella in modo generale il Freelancer
 * @param categories2
 * @param country Nazionalità
 * @param description Descrizione del suo profilo
 * @param feedback 
 * @param id
 * @param last_activity Data della sua ultima attività
 * @param member_since Data di iscrizione al sito
 * @param name Il suo nome
 * @param portfolio_items_count Numero di oggetti nel suo portfolio
 * @param portrait_50
 * @param profile_type Indica il tipo di profilo
 * @param rate
 * @param skills Array con all'interno la lista delle sue skills
 * @param test_passed_count
 * @param title
 */

public class Freelancer {
    private String[] categories2;
    private String country;
    private String description;
    private Long feedback;
    private String id;
    private LocalDate last_activity;
    private LocalDate member_since;
    private String name;
    private int portfolio_items_count;
    private String portrait_50;
    private String profile_type;
    private int rate;
    private String[] skills;
    private int test_passed_count;
    private String title;

    Freelancer(String[] categories2,
                String country,
                String description,
                Long feedback,
                String id,
                LocalDate last_activity,
                LocalDate member_since,
                String name,
                int portfolio_items_count,
                String portrait_50,
                String profile_type,
                int rate,
                String[] skills,
                int test_passed_count,
                String title){
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
     * @return Ritorna le "categories2"
     */
    public String[] getCategories2() {
        return categories2;
    }

    /**
     * @param categories2 the categories2 to set
     */
    public void setCategories2(String[] categories2) {
        this.categories2 = categories2;
    }

    /**
     * @return Ritorna le "country"
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return Ritorna le "description"
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Ritorna i "feedback"
     */
    public Long getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(Long feedback) {
        this.feedback = feedback;
    }

    /**
     * @return Ritorna gli "id"
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Ritorna le "last_activity"
     */
    public LocalDate getLast_activity() {
        return last_activity;
    }

    /**
     * @param last_activity the last_activity to set
     */
    public void setLast_activity(LocalDate last_activity) {
        this.last_activity = last_activity;
    }

    /**
     * @return Ritorna le "member_since"
     */
    public LocalDate getMember_since() {
        return member_since;
    }

    /**
     * @param member_since the member_since to set
     */
    public void setMember_since(LocalDate member_since) {
        this.member_since = member_since;
    }

    /**
     * @return Ritorna il "name"
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Ritorna il "portfolio_items_count"
     */
    public int getPortfolio_items_count() {
        return portfolio_items_count;
    }

    /**
     * @param portfolio_items_count the portfolio_items_count to set
     */
    public void setPortfolio_items_count(int portfolio_items_count) {
        this.portfolio_items_count = portfolio_items_count;
    }

    /**
     * @return String Ritorna i portrait_50
     */
    public String getPortrait_50() {
        return portrait_50;
    }

    /**
     * @param portrait_50 the portrait_50 to set
     */
    public void setPortrait_50(String portrait_50) {
        this.portrait_50 = portrait_50;
    }

    /**
     * @return String return the profile_type
     */
    public String getProfile_type() {
        return profile_type;
    }

    /**
     * @param profile_type the profile_type to set
     */
    public void setProfile_type(String profile_type) {
        this.profile_type = profile_type;
    }

    /**
     * @return int return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * @return String[] return the skills
     */
    public String[] getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    /**
     * @return int return the test_passed_count
     */
    public int getTest_passed_count() {
        return test_passed_count;
    }

    /**
     * @param test_passed_count the test_passed_count to set
     */
    public void setTest_passed_count(int test_passed_count) {
        this.test_passed_count = test_passed_count;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
