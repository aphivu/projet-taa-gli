package com.example.service;


import com.example.entity.Activite;
import com.example.entity.Personne;
import com.example.dto.PersonneDTO;

import java.util.List;

public interface IPersonneService extends MapperService<Personne,PersonneDTO> {

    public PersonneDTO getPersonneById(long id);
    public List<PersonneDTO> getPersonnes();

    public Personne createPersonne(PersonneDTO dto);
    public Personne removePersonneById(long id);



}
