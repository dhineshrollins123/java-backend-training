package com.sample.restdemo.controller;

import com.sample.restdemo.domain.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {
    @GetMapping("/hi")
    public String sayHi(){
        return "hi";
    }
    @GetMapping//Need From Server
    public Car defaultCar(){
        var car=new Car();
        car.setSpeed(100);
        car.setFwd(true);
        car.setParts(List.of("dhinesh","yogesh","vasanth"));
return car;
    }
    @PostMapping//it is used to tell to server please save car
    public Car saveCar(@RequestBody Car car){
        var cr=new Car();
        cr.setSpeed(70);
        cr.setFwd(false);
        cr.setParts(car.getParts());
        return cr;
    }
    @PutMapping // it is used to tell to server to update old car
    public Car updateCar(@RequestBody  Car updatedCar){
        return updatedCar;
    }
    @DeleteMapping("/{carId}")
    //DELETE Request - http://localhost:8080/car/any integer number-we have to pass
    public String deleteCar(@PathVariable int carId){
        return "Car Deleted SucessFully...";
    }

}
