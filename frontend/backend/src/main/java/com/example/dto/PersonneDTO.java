package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonneDTO {
    private long id;
    private String prenom;
    private String nom;
    List<ActiviteDTO> activites;

    public PersonneDTO(){
        this.activites = new ArrayList<>();
    }
    public PersonneDTO(String prenom, String nom){
        this.prenom = prenom;
        this.nom = nom;
        this.activites = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<ActiviteDTO> getActivites() {
        return activites;
    }

    public void setActivites(List<ActiviteDTO> activites) {
        this.activites = activites;
    }

    public void addActiviteDto(ActiviteDTO activiteDTO){
        this.activites.add(activiteDTO);
    }
}
