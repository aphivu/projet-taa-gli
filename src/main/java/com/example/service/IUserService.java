package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> getUsers();
    public User getUserByUsername(String username);

    public User createUser(String username,String password, String mail, String role);
    public User deleterUser(String username);

}
