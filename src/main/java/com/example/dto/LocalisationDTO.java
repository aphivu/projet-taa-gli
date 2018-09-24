package com.example.dto;

public class LocalisationDTO {

    private String ville;
    private String region;

    public LocalisationDTO(){}
    public LocalisationDTO(String ville, String region){
        this.ville = ville;
        this.region = region;
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
