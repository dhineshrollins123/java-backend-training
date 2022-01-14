package com.dk.unittesting.controller;

import com.dk.unittesting.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTests {
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;
@Test
@DisplayName("Get Car - Checking Object is not null")
    public void testGetMethod(){
       // var builder=new StringBuilder();
        String url="http://"+"localhost"+":"+port+"/car";
        Car car=template.getForObject(
                url,
                Car.class
        );
        Assertions.assertNotNull(car);
    }
}
