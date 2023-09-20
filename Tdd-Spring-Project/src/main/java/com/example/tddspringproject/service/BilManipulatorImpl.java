package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;
import org.springframework.stereotype.Service;

@Service
public class BilManipulatorImpl implements BilManipulator {
    @Override
    public Bil lightOn(Bil bil) {

        bil.lightsOn = true;

        return bil;
    }

    @Override
    public Bil lightOff(Bil bil) {

        bil.lightsOn = false;
        bil.backLights = false;
        bil.

        return bil;
    }

    @Override
    public Bil startCar(Bil testbil) {

        testbil.running = true;

        return testbil;
    }

    @Override
    public Bil stopCar(Bil testbil) {

        testbil.running = false;
        testbil.lightsOn = false;

        return testbil;
    }
}
