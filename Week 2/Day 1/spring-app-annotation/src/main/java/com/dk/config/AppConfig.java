package com.dk.config;

import com.dk.car.Car;
import com.dk.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("com.dk")
@Configuration
public class AppConfig {
    @Bean
    public Driver driver(){
        return new Driver();

    }
}
