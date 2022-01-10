package com.dk.car;

import com.dk.tempo.Tempo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Tempo tempo;
    public void speedUp(){
        System.out.println("Speeding up the Car..,");
    }
}
