package com.example.dto;

public class PersonneDTO {
    private String prenom;
    private String nom;

    public PersonneDTO(){}
    public PersonneDTO(String prenom, String nom){
        this.prenom = prenom;
        this.nom = nom;
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
}
