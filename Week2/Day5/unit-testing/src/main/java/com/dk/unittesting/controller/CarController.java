package com.dk.unittesting.controller;

import com.dk.unittesting.domain.Car;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Integer> getCarById(@PathVariable Long id)  {

        return ResponseEntity.ok(100);
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }



}
