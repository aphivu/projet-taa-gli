package com.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/**
 * Sport entity
 *
 * JsonIgnoreProperties added to avoid
 *  org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer
 *  when Jackson try to JSON-ify proxy
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sport {

    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Environment environment;

    public Sport(){
    }

    public Sport (String name) {
        this.name = name;
    }

    public Sport (String name, Environment environment){
        this.name = name;
        this.environment = environment;
    }
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

