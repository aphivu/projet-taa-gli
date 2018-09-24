package com.example.personne;

import org.springframework.stereotype.Service;

@Service
public class PersonneService implements IPersonneService {

    @Override
    public Personne mapToEntiy(PersonneDTO personneDTO) {
        return new Personne(personneDTO.getNom(),personneDTO.getPrenom());
    }

    @Override
    public PersonneDTO mapToDto(Personne personne) {
        return new PersonneDTO(personne.getPrenom(),personne.getNom());
    }
}
