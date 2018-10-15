package com.example.controller;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoginController {

    @PostMapping
    @RequestMapping("loginApp")
    public boolean testLogin(){
        return true;
    }
    
}
