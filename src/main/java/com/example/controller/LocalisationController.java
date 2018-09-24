package com.example.controller;

import com.example.repository.LocalisationRepository;
import com.example.service.ILocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for all requests about localisation
 */
@Controller
@RequestMapping("/localisation")
public class LocalisationController {
    /**
     * Service implementation wiring
     */
    @Autowired
    private ILocalisationService iLocalisationService;

    @Autowired
    private LocalisationRepository localisationRepository;
}
