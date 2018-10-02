package com.example.service;

import com.example.entity.Localisation;
import com.example.dto.LocalisationDTO;
import com.example.repository.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalisationService implements ILocalisationService {

    @Autowired
    private LocalisationRepository repository;



    @Override
    public Localisation mapToEntity(LocalisationDTO dto) {
        return new Localisation(dto.getVille(),dto.getRegion());
    }

    @Override
    public LocalisationDTO mapToDto(Localisation entity) {
        return new LocalisationDTO(entity.getVille(),entity.getRegion());
    }

    @Override
    public Localisation getLocalisationById(long id) {
        return repository.getOne(id);
    }

    @Override
    public Localisation getLocalisationByVille(String ville) {
        return repository.getLocalisationByVille(ville);
    }

    @Override
    public List<LocalisationDTO> getLocalisations() {
        List<LocalisationDTO> list = new ArrayList<>();
        for(Localisation l: repository.findAll()){
            list.add(mapToDto(l));
        }
        return list;
    }

    @Override
    public Localisation createLocalisation(LocalisationDTO dto) {
        if (repository.getLocalisationByVille(dto.getVille()) != null){
            return null;
        }
        return repository.save(mapToEntity(dto));
    }

    @Override
    public Localisation removeLocalisationById(long id) {
        if(repository.existsById(id)){
            Localisation l = repository.getOne(id);
            repository.deleteById(id);
            return l;
        }
        return null;
    }
}
