package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;



/**
 * Activite Entity class
 * Store informations about an activity
 */


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Activite {

    private long id;
    private Sport sport;
    private Localisation localisation;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    public Activite(){}
    public Activite(Sport sport, Localisation localisation){
        this.sport = sport;
        this.localisation = localisation;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
