package config;

import car.Car;
import driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.config")
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
