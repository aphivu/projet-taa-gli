package com.example.controller;


import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
