package com.example.entity;

import com.example.entity.Activite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;




/**
 * personne entity
 * store information about personnes
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Personne {

    private Long id;
    private String nom;
    private String prenom;
    private List<Activite> activites;

    public Personne(){
        this.activites = new ArrayList<Activite>();
    }

    public Personne(String nom){
        this.nom = nom;
        this.activites = new ArrayList<Activite>();
    }

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.activites = new ArrayList<Activite>();
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String preNom) {
        this.prenom = preNom;
    }

    @OneToMany(mappedBy = "personne")
    public List<Activite> getActivites() {
        if(this.activites == null){
            this.activites = new ArrayList<Activite>();
        }
        return this.activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void addActivite(Activite activite){
        this.activites.add(activite);
    }

}
