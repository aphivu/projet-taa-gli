package com.example.controller;


import com.example.dto.LocalisationDTO;
import com.example.dto.SportDTO;
import com.example.entity.Activite;
import com.example.entity.Localisation;
import com.example.entity.Sport;
import com.example.entity.User;
import com.example.service.IActiviteService;
import com.example.service.ILocalisationService;
import com.example.service.ISportService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IActiviteService activiteService;

    @Autowired
    private ISportService sportService;

    @Autowired
    private ILocalisationService localisationService;

    @RequestMapping("details")
    public User getDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByUsername(auth.getName());
    }

    @RequestMapping("sports")
    public List<SportDTO> getSports(){
        return sportService.getSports();
    }

    @RequestMapping("sports/{name}")
    public Sport getSportByName(@PathVariable String name){
        return sportService.getSportByName(name);
    }

    @RequestMapping("localisations")
    public List<LocalisationDTO> getLocalisations(){
        return localisationService.getLocalisations();
    }

    @RequestMapping("localisations/{ville}")
    public Localisation getLocalisationByVille(@PathVariable String ville){
        return localisationService.getLocalisationByVille(ville);
    }

    @RequestMapping("activities")
    public List<Activite> getActivites(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return activiteService.getActivitesByUserName(authentication.getName());
    }


}
