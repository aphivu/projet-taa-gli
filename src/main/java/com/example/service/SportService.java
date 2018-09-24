package com.example.service;

import com.example.dto.SportDTO;
import com.example.entity.Sport;
import org.springframework.stereotype.Service;

@Service
public class SportService implements ISportService{
    @Override
    public Sport mapToEntity(SportDTO dto) {
        return new Sport(dto.getName());
    }

    @Override
    public SportDTO mapToDto(Sport entity) {
        return new SportDTO(entity.getName());
    }
}
