package com.example.controller;

import com.example.repository.SportRepository;
import com.example.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
