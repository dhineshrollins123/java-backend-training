package com.dk.unittesting.service;

import com.dk.unittesting.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class CarServiceUnitTests {
    @Test
    public void testSaveCar() {
        CarServiceImpl impl = new CarServiceImpl();
        var car = new Car();
        car.setCost(56.23);
        car.setId(10L);
        car.setModel("abc");
        car.setMfg(Date.valueOf(LocalDate.now()));

        Car carRes = impl.saveCar(car);
        Assertions.assertNotNull(carRes);
    }
}
