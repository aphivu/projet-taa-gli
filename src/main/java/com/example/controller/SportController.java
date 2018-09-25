package com.example.controller;

import com.example.dto.SportDTO;
import com.example.entity.Sport;
import com.example.repository.SportRepository;
import com.example.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller to handle all sport request
 */

@Controller
@RequestMapping("/sport")
public class SportController {

    /**
     * Service Implementation Wiring
     */

    @Autowired
    SportRepository sportRepository;

    @Autowired
    ISportService iSportService;

    @GetMapping("/all")
    public @ResponseBody List<SportDTO> getAll(){
        List<SportDTO> list = new ArrayList<SportDTO>();
        Iterable<Sport> iterable = sportRepository.findAll();
        for(Sport s:iterable){
            list.add(iSportService.mapToDto(s));
        }

        return list;
    }

    @GetMapping("/{id}")
    public @ResponseBody Sport getSingle(@PathVariable long id){
        return sportRepository.getOne(id);
    }




}
