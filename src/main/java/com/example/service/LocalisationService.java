package com.example.service;

import com.example.entity.Localisation;
import com.example.dto.LocalisationDTO;
import org.springframework.stereotype.Service;

@Service
public class LocalisationService implements ILocalisationService {


    @Override
    public Localisation mapToEntity(LocalisationDTO dto) {
        return new Localisation(dto.getVille(),dto.getRegion());
    }

    @Override
    public LocalisationDTO mapToDto(Localisation entity) {
        return new LocalisationDTO(entity.getVille(),entity.getRegion());
    }
}
