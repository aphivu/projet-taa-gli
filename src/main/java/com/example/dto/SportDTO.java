package com.example.dto;

public class SportDTO {
    private String name;

    public SportDTO(){}
    public SportDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
