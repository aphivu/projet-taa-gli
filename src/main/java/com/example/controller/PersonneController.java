package com.example.controller;


import com.example.dto.ActiviteDTO;
import com.example.entity.Activite;
import com.example.entity.Localisation;
import com.example.entity.Personne;
import com.example.dto.PersonneDTO;
import com.example.entity.Sport;
import com.example.repository.ActiviteRepository;
import com.example.repository.LocalisationRepository;
import com.example.repository.PersonneRepository;
import com.example.repository.SportRepository;
import com.example.service.IActiviteService;
import com.example.service.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PersonneRepository personneRepository;

    @Autowired
    private IPersonneService personneService;

   /* @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private IActiviteService iActiviteService;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private LocalisationRepository localisationRepository;*/

    /**
     * Get all the personne in database
     * @return List of Personne DTO
     */
    @RequestMapping("/all")
    public List<PersonneDTO> getPersonnes(){
        List<PersonneDTO> list = new ArrayList<PersonneDTO>();
        for(Personne p:personneRepository.findAll()){
            list.add(personneService.mapToDto(p));
        }
        return list;
    }

    /**
     * Get all information about a personne
     * @param id : desired personne id
     * @return Personne entity
     */
    @RequestMapping("/{id}")
    public @ResponseBody Personne getPersonneById(@PathVariable Long id){
        Personne personne = personneRepository.getOne(id);
        System.out.println(personne.getNom());
        return personne;
    }

    /**
     * Post a personne entity in the database
     * @param personneDTO: Minimale needed information to map
     * @return success string
     */
    @PostMapping("/add")
    public String addPersonne(@RequestBody PersonneDTO personneDTO){

        Personne personne = personneService.mapToEntity(personneDTO);
        personneRepository.save(personne);

        return personneDTO.getPrenom() + " " + personne.getNom() + " is added";
    }


    /**
     * Remove the corresponding personne
     * @param id : personne id to remove
     * @return success string
     */
    @DeleteMapping("/remove/{id}")
    public String removePersonneById(@PathVariable long id){
        personneRepository.deleteById(id);
        return id + " has been removed";
    }



}
