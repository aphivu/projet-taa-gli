package com.example.service;


import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equals("test")) {

            return User.withDefaultPasswordEncoder()
                    .username("test")
                    .password("test")
                    .roles("test")
                    .build();
        } else {
            throw new UsernameNotFoundException("not found");
        }
    }
}
