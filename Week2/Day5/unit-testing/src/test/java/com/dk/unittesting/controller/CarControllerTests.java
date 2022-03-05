package com.dk.unittesting.controller;

import com.dk.unittesting.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTests {
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;
@Test
@DisplayName("GET-Car - Checking Object is not null")
    public void testGetMethod(){
        String url="http://"+"localhost"+":"+port+"/car";
        Car car=template.getForObject(
                url,
                Car.class
        );
        Assertions.assertNotNull(car);
    }
    @Test
    @DisplayName("GET-Car - Checking Status Code")

    public void testGetStatusCode(){
        String url="http://"+"localhost"+":"+port+"/car";
        ResponseEntity<Car> entity=template.getForEntity(url,Car.class);
        Assertions.assertEquals(HttpStatus.OK,entity.getStatusCode());
    }
@Test
@DisplayName("GET - Checking Object Content")
    public void testObjectContent(){
        String url="http://"+"localhost"+":"+port+"/car";
        var re=template.getForEntity(url,
                Car.class);
        var car=re.getBody();
        Assertions.assertEquals(car.getId(),123);

    }

    @Test
    @DisplayName("POST - Saving Car Object")
    public void testPostMethod(){
        String url="http://"+"localhost"+":"+port+"/car";
        var car=new Car();
        car.setId(456l);
        car.setCost(789.0);
        car.setModel("Old Model");
        car.setMfg(Date.valueOf(LocalDate.now()));
        var re = template.postForEntity(
                url,
                car,
                Car.class // type information of Car -> this is skeleton of the car
        );
        Assertions.assertEquals(HttpStatus.CREATED,re.getStatusCode());
    }
}
