package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class TestController {

    @PostMapping
    @RequestMapping("loginApp")
    public boolean testLogin(){

        return true;

    }
}
