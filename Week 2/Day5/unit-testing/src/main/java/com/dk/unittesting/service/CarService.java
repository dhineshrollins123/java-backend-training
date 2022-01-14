package com.dk.unittesting.service;

import com.dk.unittesting.domain.Car;

import java.util.Optional;

public interface CarService {
     Car saveCar(Car car);
     Optional<Car> findCarById(Long id);
}
