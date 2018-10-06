package com.example.controller;


import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private IUserService userService;

    /********** Admin services **********/

    @RequestMapping("admin/users")
    public List<User> getUsers(){
        System.out.println("*******************************************************");
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return userService.getUsers();
    }

    @PostMapping("admin/addUser")
    public String addUser(@RequestBody UserDTO dto){
        User user = userService.createUser(dto);
        if( user == null){
            return dto.getUsername() + " has not been added";
        }
        return user.getUsername() + " has been added";
    }

    @DeleteMapping("admin/deleteUser/{username}")
    public String removeUser(@PathVariable String username){
        User user = userService.deleterUser(username);
        if (user == null){
            return username + " has not been deleted";
        }
        return user.getUsername() + " has been deleted";
    }



    /********** User services **********/

    @RequestMapping("details")
    public User getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByUsername(auth.getName());
    }
}
