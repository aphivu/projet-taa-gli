package com.example.sport;


import javax.persistence.*;


/**
 * sport entity
 * store information about sport activity
 *
 */
@Entity
public class Sport {

    private long id;
    private String name;

    /*@Enumerated(EnumType.STRING)
    private Surface surface;
    @Enumerated(EnumType.STRING)
    private Environnement environnement;*/

    public Sport(){
    }

    public Sport (String name) {
        this.name = name;
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

   /* public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }*/


}

