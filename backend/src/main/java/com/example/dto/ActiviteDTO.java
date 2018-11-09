package com.example.dto;

public class ActiviteDTO {

    private String sport;
    private String localisation;

    public ActiviteDTO(){}
    public ActiviteDTO(String sport, String localisation) {
        this.sport = sport;
        this.localisation = localisation;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
