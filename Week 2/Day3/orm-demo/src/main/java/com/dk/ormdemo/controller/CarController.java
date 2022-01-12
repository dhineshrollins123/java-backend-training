package com.dk.ormdemo.controller;

import com.dk.ormdemo.domain.Car;
import com.dk.ormdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping
    public String saveCar(@RequestBody Car car){
        service.saveCar(car);
        return "Car SAved Sucessfully";
    }
    @DeleteMapping("/{carId}")
    public String deleteCar(@PathVariable Long carId){
        service.deleteCar(carId);
        return "Car Deleted Sucessfully";
    }
    @GetMapping
    public List<Car> findAllCars(){
        return service.findAllCars();

    }
}
