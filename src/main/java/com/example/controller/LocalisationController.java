package com.example.controller;

import com.example.dto.LocalisationDTO;
import com.example.entity.Localisation;
import com.example.service.ILocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public @ResponseBody List<LocalisationDTO> getLocalisations(){
       return iLocalisationService.getLocalisations();
    }

    @GetMapping("/id={id}")
    public @ResponseBody Localisation getLocalisation(@PathVariable long id){
        return iLocalisationService.getLocalisationById(id);
    }

    @GetMapping("/ville={ville}")
    public @ResponseBody Localisation getLocalisationByVille(@PathVariable String ville){
        return iLocalisationService.getLocalisationByVille(ville);
    }

    @PostMapping("/add")
    public String addLocalisation(@RequestBody LocalisationDTO localisationDTO){

       Localisation l = iLocalisationService.createLocalisation(localisationDTO);
       if (l == null){
           return localisationDTO.getVille() + " has not been created";
       }
       return l.getVille() + " has been created with id " + l.getId();
    }

    @DeleteMapping("/remove/{id}")
    public String removeLocalisation(@PathVariable long id){

        Localisation l = iLocalisationService.removeLocalisationById(id);
        if (l == null){
            return "No localisation to delete";
        }
        return l.getId() + " has been removed";
    }
}
