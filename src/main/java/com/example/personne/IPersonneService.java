package com.example.personne;


public interface IPersonneService {

    public Personne mapToEntiy(PersonneDTO personneDTO);
    public PersonneDTO mapToDto(Personne personne);

}
