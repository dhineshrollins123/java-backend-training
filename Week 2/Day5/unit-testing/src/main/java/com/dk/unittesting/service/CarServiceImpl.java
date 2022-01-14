package com.dk.unittesting.service;

import com.dk.unittesting.domain.Car;
import com.dk.unittesting.exception.InvalidIdException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarServiceImpl implements CarService {

    @Override
    public Car saveCar(Car car) {
        return car;
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        if(id<=0)throw new InvalidIdException("Id must be positive : "+id);
        return Optional.of(new Car());
    }
}
