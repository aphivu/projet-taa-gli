package com.example.controller;


import com.example.dto.ActiviteDTO;
import com.example.entity.*;
import com.example.dto.PersonneDTO;
import com.example.repository.ActiviteRepository;
import com.example.repository.LocalisationRepository;
import com.example.repository.PersonneRepository;
import com.example.repository.SportRepository;
import com.example.service.IActiviteService;
import com.example.service.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all requests about Personne entity
 */

@RestController
@RequestMapping("/personne")
public class PersonneController {

    /**
     * Implementation wiring with Spring
     */

    @Autowired
    private IPersonneService personneService;

    @Autowired
    private IActiviteService iActiviteService;

    /**
     * Get all the personne in database
     * @return List of Personne DTO
     */
    @RequestMapping("/all")
    public List<PersonneDTO> getPersonnes(){

       return personneService.getPersonnes();
    }

    /**
     * Get all information about a personne
     * @param id : desired personne id
     * @return Personne entity
     */
    @RequestMapping("/{id}")
    public @ResponseBody PersonneDTO getPersonneById(@PathVariable long id){

       return personneService.getPersonneById(id);
    }

    @RequestMapping("/{id}/activites")
    public @ResponseBody List<Activite> getActivites(@PathVariable long id){

       return iActiviteService.getActivitesByPersonneId(id);
    }

    /**
     * Post a personne entity in the database
     * @param personneDTO: Minimale needed information to map
     * @return success string
     */
    @PostMapping("/add")
    public String addPersonne(@RequestBody PersonneDTO personneDTO){

       Personne p = personneService.createPersonne(personneDTO);
       if (p == null) { return personneDTO.getNom() + " has not been created";}
       return p.getNom() + " has been created with id " + p.getId();
    }

    /**
     * Create an activity
     * @param id : personne id
     * @param sid : sport id
     * @param lid : localisation id
     * @return success string
     */
    @PutMapping("/{id}/activites/add")
    public @ResponseBody String addActivite(
            @PathVariable long id,
            @RequestParam long sid,
            @RequestParam long lid
    ){
        Activite a = iActiviteService.createActivite(id,sid,lid);
        if (a==null){ return "activity has not been created";}
        return a.getId() + " has been created";
    }


    /**
     * Remove the corresponding personne
     * @param id : personne id to remove
     * @return success string
     */
    @DeleteMapping("/remove/{id}")
    public String removePersonneById(@PathVariable long id){
        /*personneRepository.deleteById(id);
        return id + " has been removed";*/
        Personne p = personneService.removePersonneById(id);
        if(p ==null){ return "no personne to remove";}
        return p.getNom() + " has been removed";
    }

    @RequestMapping("/test")
    public String testCurrent(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return " user is " + authentication.getName();
    }
}





