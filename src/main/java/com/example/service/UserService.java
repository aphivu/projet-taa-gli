package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService,IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(s + " not found");
        }


        UserDetails details = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
                auths.add(new SimpleGrantedAuthority(user.getRole().toString()));
                return auths;
            }

            @Override
            public String getPassword() {
                return "{noop}" + user.getPassword(); //not safe -> no encoding pwd
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

        return details;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(String username, String password, String mail, String role) {
        if (getUserByUsername(username) != null){ return null;}
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.valueOf(role));
        user.setMail(mail);

        return userRepository.save(user);
    }

    @Override
    public User deleterUser(String username) {
        User user = getUserByUsername(username);
        if (user == null){ return null;}
        userRepository.delete(user);
        return user;
    }
}
