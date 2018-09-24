package com.example.service;

import com.example.entity.Personne;
import com.example.dto.PersonneDTO;
import org.springframework.stereotype.Service;

@Service
public class PersonneService implements IPersonneService {


    @Override
    public Personne mapToEntity(PersonneDTO dto) {

        return new Personne(dto.getNom(),dto.getPrenom());
    }

    @Override
    public PersonneDTO mapToDto(Personne personne) {

        return new PersonneDTO(personne.getPrenom(),personne.getNom());
    }


}
