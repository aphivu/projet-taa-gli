package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoginController {

    /**
     * If Authentication header is correct
     * @return true
     * Basic Auth is test with spring security
     * Error response will be returned for wrong credentials
     *
     * TODO:
     * Change this solution
     */
    @PostMapping("loginApp")
    public boolean testLogin(){
        return true;
    }
    
}
