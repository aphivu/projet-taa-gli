package com.example.service;

import com.example.dto.SportDTO;
import com.example.entity.Sport;

import java.util.List;

public interface ISportService extends MapperService<Sport, SportDTO> {

    public Sport getSportById(long id);
    public Sport getSportByName (String name);
    public List<SportDTO> getSports();
    public Sport createSport(SportDTO dto);
    public Sport removeSport(long id);


}
