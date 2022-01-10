package com.dk.config;

import com.dk.car.Car;
import com.dk.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.dk")
@Configuration
public class AppConfig {
    @Bean
    public Car car(){
        return new Car();
    }
    @Bean
    public Driver driver(){
        return new Driver();

    }
}
