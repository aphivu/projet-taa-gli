package com.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Localisation entity
 * store informations of activity localisation
 *
 * JsonIgnoreProperties added to avoid
 * org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer
 * when Jackson try to JSON-ify proxied Localisation
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Localisation {

    private long id;
    private String ville;
    private String region;

    public Localisation(){}
    public Localisation(String ville){
        this.ville = ville;
    }
    public Localisation(String ville, String region){
        this.ville = ville;
        this.region = region;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
