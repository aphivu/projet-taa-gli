package com.example.controller;


import com.example.entity.Personne;
import com.example.dto.PersonneDTO;
import com.example.repository.PersonneRepository;
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
    public @ResponseBody Personne getPersonne(@PathVariable Long id){
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
    public String addSingle(@RequestBody PersonneDTO personneDTO){

        Personne personne = personneService.mapToEntity(personneDTO);
        personneRepository.save(personne);

        return personneDTO.getPrenom() + " " + personne.getNom() + " is added";
    }


}
