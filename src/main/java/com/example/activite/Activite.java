package com.example.activite;

import com.example.localisation.Localisation;
import com.example.personne.Personne;
import com.example.sport.Sport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/**
 * Activite Entity class
 * Store informations about an activity
 */


@Entity
public class Activite {

    private long id;
    private Personne personne;
    private Sport sport;
    private Localisation localisation;

    //@Enumerated(EnumType.STRING)
    //private Niveau niveau;

    public Activite(){}
    public Activite(Personne personne, Sport sport, Localisation localisation){
        this.personne = personne;
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
    @JsonIgnore
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
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

    /*public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }*/
}
