package com.example.personne;

import com.example.activite.Activite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    public Personne(){}

    public Personne(String nom){
        this.nom = nom;
    }

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
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
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }
}
