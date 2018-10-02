package com.example.controller;

import com.example.dto.SportDTO;
import com.example.entity.Sport;
import com.example.repository.SportRepository;
import com.example.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller to handle all sport request
 */

@RestController
@RequestMapping("/sport")
public class SportController {

    /**
     * Service Implementation Wiring
     */
    @Autowired
    ISportService iSportService;


    /**
     * Get all available sports
     * @return List of sport dto
     */
    @GetMapping("/all")
    public @ResponseBody List<SportDTO> getAll(){

       return iSportService.getSports();
    }


    /**
     * Get a specific sport
     * @param id :sport id to return
     * @return all information from entity
     */
    @GetMapping("/id={id}")
    public @ResponseBody Sport getSportById(@PathVariable long id){

        return iSportService.getSportById(id);
    }


    /**
     * Get a specific sport
     * @param name : sport name to return
     * @return all information from entity
     */
    @GetMapping("/name={name}")
    public @ResponseBody Sport getSportByName(@PathVariable String name){
        return iSportService.getSportByName(name);
    }


    /**
     * create a personne into the db
     * @param sportDTO : needed information to create sport entity
     * @return success string
     */
    @PostMapping("/add")
    public String addSport(@RequestBody SportDTO sportDTO){

      Sport s = iSportService.createSport(sportDTO);
      if (s == null){ return sportDTO.getName() + " has not been created";}

      return s.getName() + " has been added with id " + s.getId();
    }


    /**
     * Remove a specific sport
     * @param id : sport id to remove
     * @return success string
     */
    @DeleteMapping("/remove/{id}")
    public String removeSport(@PathVariable long id){

       Sport s = iSportService.removeSport(id);
       if (s == null){ return " no sport to remove";}

       return  s.getId() + " has been removed";
    }




}
