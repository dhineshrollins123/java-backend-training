package com.dk.unittesting.service;

import com.dk.unittesting.domain.Car;
import com.dk.unittesting.exception.InvalidIdException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
public class CarServiceTests {
    @Autowired
    private CarServiceImpl service;

    @DisplayName("Service : Car is Not Null")
    @Test
    public void testCarSave(){
        Car car=new Car();
        car.setCost(56.23);
        car.setId(10L);
        car.setModel("abc");
        car.setMfg(Date.valueOf("2020-10-01"));

        Car resCar = service.saveCar(car);
        Assertions.assertNotNull(resCar);
    }

    @DisplayName("Service : Car Equality")
    @Test
    public void testCarEquality(){
        Car car = new Car();
        car.setCost(56.23);
        car.setId(10L);
        car.setModel("abc");
        car.setMfg(Date.valueOf("2020-10-01"));
        Car resCar = service.saveCar(car);
        Assertions.assertEquals(car, resCar);
    }

    @DisplayName("Service : Car by id : valid")
    @Test
    public void testCarByIdValid(){
        Optional<Car> op=service.findCarById(10l);
        Assertions.assertNotNull(op.get());
    }

    @DisplayName("Service : Car by id :  In valid")
    @Test
    public void testCarByIdInValid(){
        Assertions.assertThrows(
                InvalidIdException.class,
                () -> service.findCarById(-10l)
        );
    }
}
