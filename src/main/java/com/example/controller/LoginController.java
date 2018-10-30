package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoginController {

    @PostMapping("loginApp")
    public boolean testLogin(){
        return true;
    }
    
}
