package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.entity.Activite;
import com.example.entity.Personne;
import com.example.dto.PersonneDTO;
import com.example.repository.ActiviteRepository;
import com.example.repository.LocalisationRepository;
import com.example.repository.PersonneRepository;
import com.example.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneService implements IPersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private ActiviteService activiteService;

    @Override
    public Personne mapToEntity(PersonneDTO dto) {

        return new Personne(dto.getNom(),dto.getPrenom());
    }

    @Override
    public PersonneDTO mapToDto(Personne personne) {

        return new PersonneDTO(personne.getPrenom(),personne.getNom());
    }


    @Override
    public PersonneDTO getPersonneById(long id) {
        Personne personne = personneRepository.getOne(id);
        PersonneDTO personneDTO = new PersonneDTO(personne.getPrenom(),personne.getNom());
        for(Activite a:personne.getActivites()){
            personneDTO.addActiviteDto(activiteService.mapToDto(a));
        }
        return personneDTO;
    }

    @Override
    public List<PersonneDTO> getPersonnes() {
        List<PersonneDTO> list = new ArrayList<>();

        for(Personne p:personneRepository.findAll()){
            list.add(mapToDto(p));
        }
        return list;
    }

    @Override
    public Personne createPersonne(PersonneDTO dto) {
        return personneRepository.save(mapToEntity(dto));
    }

    @Override
    public Personne removePersonneById(long id) {
        if (personneRepository.existsById(id)){
            Personne p = personneRepository.getOne(id);
            personneRepository.deleteById(id);
            return p;
        }
        return null;
    }
}
