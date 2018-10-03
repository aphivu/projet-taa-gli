package com.example;


import com.example.controller.PersonneController;
import com.example.dto.PersonneDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired PersonneController personneController;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(personneController).build();
    }

    @Test
    public void testGetPersonnes() throws Exception {
       ResultActions actions =  mockMvc.perform(get("/personne/all"));

       actions.andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    @Transactional
    public void testGetPersonne() throws Exception {
        long idPersonne = 1;

        ResultActions actions = mockMvc.perform(get("/personne/{id}",idPersonne));
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.nom",is("Robert")));


    }


    @Test
    public void testAddPersonne() throws Exception {
        PersonneDTO dto = new PersonneDTO("nomTest","prenomTest");
        /*
        ResultActions actions = mockMvc.perform(post("/personne/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nom\":\""+dto.getNom()+"\",\"prenom\":\""+dto.getPrenom()+"\"}"));
        actions.andExpect(status().isOk());*/


    }





}
