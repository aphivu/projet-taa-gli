package com.example.service;

import com.example.dto.SportDTO;
import com.example.entity.Sport;
import com.example.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Sport service Bean
 */
@Service
public class SportService implements ISportService{

    @Autowired
    private SportRepository repository;

    @Override
    public Sport mapToEntity(SportDTO dto) {
        return new Sport(dto.getName(),dto.getEnvironment());
    }

    @Override
    public SportDTO mapToDto(Sport entity) {
        return new SportDTO(entity.getName());
    }


    @Override
    public Sport getSportById(long id) {
        return repository.getOne(id);
    }

    @Override
    public Sport getSportByName(String name) {
        return repository.getSportByName(name);
    }

    @Override
    public List<SportDTO> getSports() {
        List<SportDTO> list = new ArrayList<>();
        for(Sport s:repository.findAll()){
            list.add(mapToDto(s));
        }
        return list;
    }

    @Override
    public Sport createSport(SportDTO dto) {

        if (repository.getSportByName(dto.getName()) != null){ return null;}

        return repository.save(mapToEntity(dto));
    }

    @Override
    public Sport removeSport(long id) {

        if (repository.existsById(id)){
            Sport s = repository.getOne(id);
            repository.deleteById(id);
            return s;
        }
        return null;
    }
}
