package com.dk.app.dockerized.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.regex.Matcher;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppController.class)
public class AppControllerTests {

    @Autowired
    private MockMvc mvc;

    @DisplayName("Controller:Checking Status")
    @Test
    public void testAppControllerStatus() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/app/")
                ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }
    @DisplayName("Controller:Test APP Object")
    @Test
    public void testAppControllerObject() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/app/"))
            .andExpect(MockMvcResultMatchers
                    .jsonPath("$.name", Matchers.is("abc")));
}
}
