package com.example.controller;

import com.example.dto.LocalisationDTO;
import com.example.entity.Localisation;
import com.example.repository.LocalisationRepository;
import com.example.service.ILocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Controller for all requests about localisation
 */
@RestController
@RequestMapping("/localisation")
public class LocalisationController {
    /**
     * Service implementation wiring
     */
    @Autowired
    private ILocalisationService iLocalisationService;

    @Autowired
    private LocalisationRepository localisationRepository;

    @GetMapping("/all")
    public @ResponseBody List<LocalisationDTO> getLocalisations(){
        Iterable<Localisation> iterable = localisationRepository.findAll();
        List<LocalisationDTO> list = new ArrayList<LocalisationDTO>();
        for(Localisation l:iterable){
            list.add(iLocalisationService.mapToDto(l));
        }
        return list;
    }

    @GetMapping("/{id}")
    public @ResponseBody Localisation getLocalisation(@PathVariable long id){
        return localisationRepository.getOne(id);
    }

    @PostMapping("/add")
    public String addLocalisation(@RequestBody LocalisationDTO localisationDTO){
        Localisation localisation = iLocalisationService.mapToEntity(localisationDTO);
        localisationRepository.save(localisation);

        return localisation.getVille() + " has been created";
    }

    @DeleteMapping("/remove/{id}")
    public String removeLocalisation(@PathVariable long id){
        localisationRepository.deleteById(id);

        return id + " has been removed";
    }
}
