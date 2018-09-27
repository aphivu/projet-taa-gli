package com.example.service;

import com.example.entity.Activite;
import com.example.entity.Personne;
import com.example.dto.PersonneDTO;
import com.example.repository.LocalisationRepository;
import com.example.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
