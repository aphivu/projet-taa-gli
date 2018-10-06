package com.example;

import com.example.dto.SportDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    private String validUser = "user";
    private String validAdmin = "admin";
    private String validPwd = "password";
    private String invalidLogin = "invalid";

    @Before
    public void setup(){
       this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
               .apply(SecurityMockMvcConfigurers.springSecurity())
               .build();
    }

    /****** GET *****/

    @Test
    public void getDetailsSuccess() throws Exception {
        this.mockMvc.perform(get("/user/details")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk());
    }

    @Test
    public void getDetailsFail() throws  Exception {
        this.mockMvc.perform(get("/user/details")
                .with(httpBasic(invalidLogin,validPwd)))
                .andExpect(status().is(401));

    }

    @Test
    public void getUsersSuccess() throws Exception {
        this.mockMvc.perform(get("/admin/users")
                .with(httpBasic(validAdmin,validPwd)))
                .andExpect(status().isOk());
    }

    @Test
    public void getUsersFail() throws Exception {
        this.mockMvc.perform(get("/admin/users")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().is(403));
    }

    @Test
    public void getSportSuccess() throws Exception {
        this.mockMvc.perform(get("/user/sports")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)));
    }

    @Test
    public void getLocalisationSuccess() throws Exception {
        this.mockMvc.perform(get("/user/localisations")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    /******* Post *****/
    @Test
    public void addSportSuccess() throws Exception {

        SportDTO dto = new SportDTO("Surf");
        this.mockMvc.perform(post("/admin/addSport")
                .with(httpBasic(validAdmin,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void addSportFailed() throws Exception {
        SportDTO dto = new SportDTO("SportTest");
        this.mockMvc.perform(post("/admin/addSport")
                .with(httpBasic(validUser,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isForbidden());
    }



}
