package com.example.controller;

import com.example.dto.LocalisationDTO;
import com.example.dto.SportDTO;
import com.example.dto.UserDTO;
import com.example.entity.Localisation;
import com.example.entity.Sport;
import com.example.entity.User;
import com.example.service.ILocalisationService;
import com.example.service.ISportService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Rest controller to handle all admin services
 *
 */

@RestController
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ISportService iSportService;

    @Autowired
    private ILocalisationService iLocalisationService;


    /**
     * Get all users registered in the DB
     * @return List of User entity
     */
    @GetMapping("users")
    public List<User> getUsers(){
        return iUserService.getUsers();
    }

    /**
     * Add a user in the DB
     * @param dto: necessary data to perform a create query
     * @return  response string
     */
    @PostMapping("addUser")
    public String addUser(@RequestBody UserDTO dto){
        User user = iUserService.getUserByUsername(dto.getUsername());
        if (user != null){ return dto.getUsername() + " is already registered";}
        return iUserService.createUser(dto).getUsername() + " has been registered";
    }

    /**
     * Add a user in the DB
     * @param dto : necessary data to perform an insert into
     * @return response string
     */
    @PostMapping("addSport")
    public String addSport(@RequestBody SportDTO dto){
        Sport sport = iSportService.getSportByName(dto.getName());
        if (sport != null){ return dto.getName() + " is already registered";}

        return iSportService.createSport(dto).getName() + " has been registered";
    }

    /**
     * Add a localisation in the DB
     * @param dto : necessary data to perform an insert into
     * @return response success
     */
    @PostMapping("addLocalisation")
    public String addLocalisation(@RequestBody LocalisationDTO dto){
        Localisation localisation = iLocalisationService.getLocalisationByVille(dto.getVille());
        if (localisation != null) { return dto.getVille() + " is already registered";}

        return iLocalisationService.createLocalisation(dto).getVille() + " has been registered";
    }

    /**
     * Remove a user in the DB
     * @param username : id user to remove
     * @return response string
     */
    @DeleteMapping("deleterUser/{username}")
    public String deleteUser(@PathVariable String username){
        User user = iUserService.getUserByUsername(username);
        if (user == null) { return " Not registered";}
        return iUserService.deleteUser(user.getUsername()).getUsername() + " has been deleted";
    }

    /**
     * remove a Sport in the db
     * @param sportName : name identification to remove
     * @return response string
     */
    @DeleteMapping("deleteSport/{sportName}")
    public String deleteSport(@PathVariable String sportName){
        Sport sport = iSportService.getSportByName(sportName);
        if (sport == null) { return " Not registered";}
        return iSportService.removeSport(sport.getId()).getName() + " has been deleted";
    }

    /**
     * remove a localisation from the DB
     * @param ville : ville to identify
     * @return response string
     */
    @DeleteMapping("deleteLocalisation/{ville}")
    public String deleteLocalisation(@PathVariable String ville){
        Localisation localisation = iLocalisationService.getLocalisationByVille(ville);
        if (localisation == null) { return " Not registered";}
        return iLocalisationService.removeLocalisationById(localisation.getId()).getVille() + " has been deleted";
    }



}
