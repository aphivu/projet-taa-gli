package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.dto.UserDTO;
import com.example.dto.UserDetailsDto;
import com.example.entity.Activite;
import com.example.entity.Role;
import com.example.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Service component to handle request on user entity
 */
@Service
public class UserService extends UserDetailsServiceImpl implements IUserService {

    @Autowired
    private ActiviteService activiteService;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetailsDto getUserDetails(String username) {
        User user = getUserByUsername(username);
        UserDetailsDto details = new UserDetailsDto(mapToDto(user));
        details.setDto(mapToDto(user));
        for(Activite activite:user.getActivites()){
            details.getActivities().add(activiteService.mapToDto(activite));
        }
        return details;
    }

    @Override
    public User createUser(UserDTO dto) {
        if (getUserByUsername(dto.getUsername()) != null){ return null;}

        return userRepository.save(mapToEntity(dto));
    }

    @Override
    public User deleteUser(String username) {
        User user = getUserByUsername(username);
        if (user == null){ return null;}
        userRepository.delete(user);
        return user;
    }

    @Override
    public User addActivity(String username, ActiviteDTO dto) {
        User user = getUserByUsername(username);
        List<Activite> list = user.getActivites();
        for (Activite a:list){
            if (a.getSport().getName().equals(dto.getSport()) && a.getLocalisation().getVille().equals(dto.getLocalisation())){
                return user;
            }
        }

        Activite activite = activiteService.createActivite(dto);

        list.add(activite);

        user.setActivites(list);

        return userRepository.save(user);
    }

    @Override
    public User removeActivity(String username, long id) {
        activiteService.removeActiviteById(id);
        return getUserByUsername(username);
    }

    @Override
    public List<Activite> getActivities(String username) {
        return getUserByUsername(username).getActivites();
    }

    @Override
    public User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setMail(dto.getMail());
        user.setRole(Role.valueOf(dto.getRole()));
        return user;
    }

    @Override
    public UserDTO mapToDto(User entity) {
        UserDTO dto = new UserDTO(
                entity.getUsername(),
                entity.getPassword(),
                entity.getMail(),
                entity.getRole().toString()
        );
        return dto;
    }

}
