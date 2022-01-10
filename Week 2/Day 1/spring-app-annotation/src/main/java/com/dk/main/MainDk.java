package com.dk.main;

import com.dk.car.Car;
import com.dk.config.AppConfig;
import com.dk.driver.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainDk {

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Car car=(Car)context.getBean("car");
        Driver driver=(Driver)context.getBean("driver");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
