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
    SportRepository sportRepository;

    @Autowired
    ISportService iSportService;


    /**
     * Get all available sports
     * @return List of sport dto
     */
    @GetMapping("/all")
    public @ResponseBody List<SportDTO> getAll(){
        List<SportDTO> list = new ArrayList<SportDTO>();
        Iterable<Sport> iterable = sportRepository.findAll();
        for(Sport s:iterable){
            list.add(iSportService.mapToDto(s));
        }

        return list;
    }


    /**
     * Get a specific sport
     * @param id :sport id to return
     * @return all information from entity
     */
    @GetMapping("/{id}")
    public @ResponseBody Sport getSportById(@PathVariable long id){
        return sportRepository.getOne(id);
    }

    @GetMapping("/{name")
    public @ResponseBody Sport getSportByName(@PathVariable String name){
        //sportRepository.f

        return null;
    }


    /**
     * create a personne into the db
     * @param sportDTO : needed information to create sport entity
     * @return success string
     */
    @PostMapping("/add")
    public String addSport(@RequestBody SportDTO sportDTO){
        Sport sport = iSportService.mapToEntity(sportDTO);
        sportRepository.save(sport);
        return sport.getName() + " is added";
    }


    /**
     * Remove a specific sport
     * @param id : sport id to remove
     * @return success string
     */
    @DeleteMapping("/remove/{id}")
    public String removeSport(@PathVariable long id){
        sportRepository.deleteById(id);

        return id + " has been removed.";
    }




}
