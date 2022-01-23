package com.dk.week3.BillingModule.controller;

import com.dk.week3.BillingModule.service.BillService1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(BillController1.class)
public class BillControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillService1 service1;

    @DisplayName("Controller1: Checking Status")
    @Test
    public void testAppControllerStatus() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/billcon1/allbills/"))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()

        );
    }



}
