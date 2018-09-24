package com.example.controller;

import com.example.repository.ActiviteRepository;
import com.example.service.IActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller to handle all activity request
 */
@Controller
@RequestMapping("/activite")
public class ActiviteController {

    /**
     * Service Implementation Wiring
     */

    @Autowired
    ActiviteRepository activiteRepository;

    @Autowired
    IActiviteService iActiviteService;
}
