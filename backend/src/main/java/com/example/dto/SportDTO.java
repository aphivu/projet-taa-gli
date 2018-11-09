package com.example.dto;

import com.example.entity.Environment;

public class SportDTO {

    private String name;
    private Environment environment;

    public SportDTO(){}
    public SportDTO(String name) {
        this.name = name;
    }
    public SportDTO(String name,Environment environment) {
        this.name = name;
        this.environment = environment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
