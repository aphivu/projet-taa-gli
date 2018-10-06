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
    private PersonneRepository personneRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private LocalisationRepository localisationRepository;

    @Override
    public Activite mapToEntity(ActiviteDTO dto) {
        /**
         * TODO: make imlementation if necessary
         */
        return null;
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
    public List<Activite> getActivitesByUserName(String username) {
        return null;
    }


    @Override
    public Activite createActivite(long pid, long sid, long lid) {
        /*if (activiteRepository.getActiviteByAllId(pid,sid,lid) != null){
            return null;
        }
        /*Personne personne = personneRepository.getOne(pid);
        Sport sport = sportRepository.getOne(sid);
        Localisation localisation = localisationRepository.getOne(lid);
        return activiteRepository.save(new Activite(personne,sport,localisation));*/
        return null;
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
