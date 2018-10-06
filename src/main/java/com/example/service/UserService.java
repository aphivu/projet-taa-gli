package com.example.service;

import com.example.dto.UserDTO;
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


import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService extends UserDetailsServiceImpl implements IUserService {


    @Override
    public List<User> getUsers() {
        System.out.println("************* service layer");
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(UserDTO dto) {
        if (getUserByUsername(dto.getUsername()) != null){ return null;}

        return userRepository.save(mapToEntity(dto));
    }

    @Override
    public User deleteUser(String username) {
        User user = getUserByUsername(username);
        if (user == null){ return null;}
        userRepository.delete(user);
        return user;
    }

    @Override
    public User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setMail(dto.getMail());
        user.setRole(Role.valueOf(dto.getRole()));
        return user;
    }

    @Override
    public UserDTO mapToDto(User entity) {
        UserDTO dto = new UserDTO(
                entity.getUsername(),
                entity.getPassword(),
                entity.getMail(),
                entity.getRole().toString()
        );
        return dto;
    }
}
