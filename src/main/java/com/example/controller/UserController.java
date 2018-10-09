package com.example.controller;


import com.example.dto.*;
import com.example.entity.Activite;
import com.example.entity.Localisation;
import com.example.entity.Sport;
import com.example.service.ILocalisationService;
import com.example.service.ISportService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * Rest Controller to handle user services
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISportService sportService;

    @Autowired
    private ILocalisationService localisationService;

    /**
     * Get user detailed information
     * @return DTO for users
     */
    @RequestMapping("details")
    public UserDetailsDto getDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserDetails(auth.getName());
    }

    /**
     * Get the sport list of available sport in the db
     * @return List of Sport
     */
    @RequestMapping("sports")
    public List<SportDTO> getSports(){
        return sportService.getSports();
    }

    /**
     * Get all specific sport informations
     * @param name: the sport to detailed
     * @return Sport entity
     * */
    @RequestMapping("sports/{name}")
    public Sport getSportByName(@PathVariable String name){
        return sportService.getSportByName(name);
    }

    /**
     * Get the available localisations
     * @return List of Localisation entity
     */
    @RequestMapping("localisations")
    public List<LocalisationDTO> getLocalisations(){
        return localisationService.getLocalisations();
    }

    @RequestMapping("localisations/{ville}")
    public Localisation getLocalisationByVille(@PathVariable String ville){
        return localisationService.getLocalisationByVille(ville);
    }

    /**
     * Get all the user activities
     * @return List of Activite entities
     */
    @RequestMapping("activities")
    public List<Activite> getActivites(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userService.getActivities(authentication.getName());
    }

    /**
     * Add an activity for the connected user
     * @param dto: the necessary data to perform Insert into
     * @return response string
     */
    @PostMapping("activities/add")
    public String addActivity(@RequestBody ActiviteDTO dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userService.addActivity(authentication.getName(),dto).getUsername() + " has added activity";
    }

    /**
     * Remove a specified activity
     * @param id : activity id to remove
     * @return response string
     */
    @DeleteMapping("activities/delete/{id}")
    public String deleteActivity(@PathVariable long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.removeActivity(authentication.getName(),id).getUsername() + " has removed activity";
    }


}
