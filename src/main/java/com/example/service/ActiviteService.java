package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.entity.Activite;
import com.example.entity.Localisation;
import com.example.entity.Personne;
import com.example.entity.Sport;
import com.example.repository.ActiviteRepository;
import com.example.repository.LocalisationRepository;
import com.example.repository.PersonneRepository;
import com.example.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActiviteService implements IActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;


    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private LocalisationRepository localisationRepository;

    @Override
    public Activite mapToEntity(ActiviteDTO dto) {
        Sport sport = sportRepository.getSportByName(dto.getSport());
        Localisation localisation = localisationRepository.getLocalisationByVille(dto.getLocalisation());
        if (sport == null || localisation == null){ return null;}
        return new Activite(sport,localisation);
    }

    @Override
    public ActiviteDTO mapToDto(Activite entity) {
        return new ActiviteDTO(entity.getSport().getName(),
                entity.getLocalisation().getVille());
    }

    @Override
    public Activite getActiviteById(long id) {
        return activiteRepository.getOne(id);
    }

    @Override
    public Activite createActivite(ActiviteDTO dto) {
        return activiteRepository.save(mapToEntity(dto));
    }

    @Override
    public Activite removeActiviteById(long id) {
        if(activiteRepository.existsById(id)){
            Activite a = activiteRepository.getOne(id);
            activiteRepository.deleteById(id);
            return a;
        }
        return null;
    }
}
