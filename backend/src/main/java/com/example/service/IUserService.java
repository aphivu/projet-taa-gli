package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.dto.UserDTO;
import com.example.dto.UserDetailsDto;
import com.example.entity.Activite;
import com.example.entity.User;


import java.util.List;

/**
 * User service component
 */
public interface IUserService extends MapperService<User, UserDTO>{


    public List<User> getUsers();
    public User getUserByUsername(String username);
    public UserDetailsDto getUserDetails(String username);

    public User createUser(UserDTO dto);
    public User deleteUser(String username);

    public User addActivity(String username,ActiviteDTO dto);
    public User removeActivity(String username, long id);
    public List<Activite> getActivities(String username);
}
