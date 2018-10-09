package com.example.service;

import com.example.entity.Localisation;
import com.example.dto.LocalisationDTO;

import java.util.List;

/**
 * Localisation service component
 */
public interface ILocalisationService extends MapperService<Localisation,LocalisationDTO>{

    public Localisation getLocalisationById(long id);
    public Localisation getLocalisationByVille(String ville);
    public List<LocalisationDTO> getLocalisations();

    public Localisation createLocalisation(LocalisationDTO dto);
    public Localisation removeLocalisationById(long id);

}
