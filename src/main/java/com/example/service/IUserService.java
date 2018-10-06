package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.User;


import java.util.List;

public interface IUserService extends MapperService<User, UserDTO>{


    public List<User> getUsers();
    public User getUserByUsername(String username);

    public User createUser(UserDTO dto);
    public User deleteUser(String username);

}
