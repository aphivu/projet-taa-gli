package com.example;

import com.example.dto.ActiviteDTO;
import com.example.dto.LocalisationDTO;
import com.example.dto.SportDTO;
import com.example.dto.UserDTO;
import com.example.entity.Environment;
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
    private String validPwd = "testpwd";

    @Before
    public void setup(){
       this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
               .apply(SecurityMockMvcConfigurers.springSecurity())
               .build();
    }

   // GET

    @Test
    public void getDetailsSuccess() throws Exception {
        this.mockMvc.perform(get("/user/details")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk());
    }

    @Test
    public void getDetailsFail() throws  Exception {
        this.mockMvc.perform(get("/user/details")
                .with(httpBasic("invalid",validPwd)))
                .andExpect(status().is(401));

    }

    @Test
    public void getUsersSuccess() throws Exception {
        this.mockMvc.perform(get("/admin/users")
                .with(httpBasic(validAdmin,validPwd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)));
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
                .andExpect(status().isOk());
    }

    @Test
    public void getSportFail() throws Exception {
        this.mockMvc.perform(get("/user/sports"))
                .andExpect(status().is(401));
    }

    @Test
    public void getLocalisationSuccess() throws Exception {
        this.mockMvc.perform(get("/user/localisations")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }

    @Test
    public void getLocalisationFail() throws Exception {
        this.mockMvc.perform(get("/user/localisations"))
                .andExpect(status().is(401));
    }

    @Test
    public void getSportByNameSuccess() throws Exception {
        this.mockMvc.perform(get("/user/sports/Tennis")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk());
    }

    @Test
    public void getLocalisationByVille() throws Exception {
        this.mockMvc.perform(get("/user/localisations/Rennes")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.region").value("Bretagne"));
    }

    @Test
    public void getActivities() throws Exception {
        this.mockMvc.perform(get("/user/activities")
                .with(httpBasic(validUser,validPwd)))
                .andExpect(status().isOk());
    }

    // POST


    @Test
    public void postUserSuccess() throws Exception {
        UserDTO dto = new UserDTO("manuemael","password","manuemael@mail.com","ROLE_USER");

        this.mockMvc.perform(post("/admin/addUser")
                .with(httpBasic(validAdmin,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

    }

    @Test
    public void postUserFail() throws Exception {
        UserDTO dto = new UserDTO("manuemael","password","manuemael@mail.com","ROLE_USER");

        this.mockMvc.perform(post("/admin/addUser")
                .with(httpBasic(validUser,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isForbidden());
    }

    @Test
    public void postSportSuccess() throws Exception {

        SportDTO dto = new SportDTO("Surf", Environment.OUTSIDE);
        this.mockMvc.perform(post("/admin/addSport")
                .with(httpBasic(validAdmin,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void postSportFailed() throws Exception {
        SportDTO dto = new SportDTO("SportTest");
        this.mockMvc.perform(post("/admin/addSport")
                .with(httpBasic(validUser,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isForbidden());
    }

    @Test
    public void postLocalisationSuccess() throws Exception {
        LocalisationDTO dto = new LocalisationDTO("Nantes","Pays de la Loire");
        this.mockMvc.perform(post("/admin/addLocalisation")
                .with(httpBasic(validAdmin,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void postLocalisationFail() throws Exception {
        LocalisationDTO dto = new LocalisationDTO("Nantes","Pays de la Loire");
        this.mockMvc.perform(post("/admin/addLocalisation")
                .with(httpBasic(validUser,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isForbidden());
    }


    /*@Test
    public void postActivity() throws Exception {
        ActiviteDTO dto = new ActiviteDTO("Tennis","Rennes");
        this.mockMvc.perform(post("/user/activities/add")
                .with(httpBasic(validUser,validPwd))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }*/

    // DELETE
    /**
     * TODO: Implement Delete request test
     */

}
