package com.springbootdemo;

import com.springbootdemo.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getUser() throws Exception{
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/").param("name","getUser")).andReturn().getResponse().getContentAsString();
        System.out.println("result: " + responseString);
    }

    @Test
    public void saveUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name","").param("age","666").param("pass","test"));
    }

}
