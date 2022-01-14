package com.dk.unittesting.controller;

import com.dk.unittesting.domain.Car;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;


@RequestMapping("/car")
@RestController
public class CarController {
    @GetMapping()
    public ResponseEntity<Car> getCar(){
       var car=new Car();
       car.setId(123l);
       car.setCost(10000.00);
       car.setMfg(Date.valueOf(LocalDate.now()));
       car.setModel("Brand New");
       return ResponseEntity.ok(car);

    }

}
