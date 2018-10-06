package com.example;


import com.example.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {


    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;

   // @Autowired
   // private UserController userController;

    @Before
    public void setup(){
       this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
               .apply(SecurityMockMvcConfigurers.springSecurity())
               .build();
    }

    @Test
    @WithMockUser
    public void getDetailsSuccess() throws Exception {
        this.mockMvc.perform(get("/details"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "invalid")
    public void getDetailsFail() throws  Exception {
        this.mockMvc.perform(get("/details"))
                .andExpect(jsonPath("$.username").doesNotExist());
    }

    @Test
    public void getUsersSuccess() throws Exception {
        this.mockMvc.perform(get("/admin/users").with(httpBasic("admin","password")))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void getUsersFail() throws Exception {
        this.mockMvc.perform(get("/admin/users"))
                .andExpect(status().is(403));
    }
}
