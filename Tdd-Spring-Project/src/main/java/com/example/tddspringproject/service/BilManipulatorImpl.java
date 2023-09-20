package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;
import org.springframework.stereotype.Service;

@Service
public class BilManipulatorImpl implements BilManipulator {
    @Override
    public Bil startCar(Bil bil) {
        bil.running = true;
        return bil;
    }

    @Override
    public Bil stopCar(Bil bil) {
        bil.running = false;
        bil = bilManipulator.LightsOff(bil);
        return bil;
    }

    @Override
    public Bil lightsOn(Bil bil) {
        bil.lightsOn = true;
        bil = bilManipulator.halfLightsOn(bil);
        bil = bilManipulator.backLightsOn(bil);
        return bil;
    }

    @Override
    public Bil lightsOff(Bil bil) {
        bil.lightsOn = false;
        bil = bilManipulator.halfLightsOff(bil);
        bil = bilManipulator.fullLightsOff(bil);
        bil = bilManipulator.backLightsOff(bil);
        return bil;
    }

    @Override
    public Bil halfLifhtsOn(Bil bil) {
        if (bil.running) {
            bil.halfLightsOn = true;
            bil = bilManipulator.fullLightsOff(bil);
        }
        return bil;
    }

    @Override
    public Bil halfLightOff(Bil bil) {
        bil.halfLifhtsOn = false;
        return bil;
    }

    @Override
    public Bil fullLifhtsOn(Bil bil) {
        if (bil.running) {
            bil.fullLightsOn = true;
            bil = bilManipulator.halfLightsOff(bil);
        }
        return bil;
    }

    @Override
    public Bil fullLightOff(Bil bil) {
        bil.fullLifhtsOn = false;
        return bil;
    }

    @Override
    public Bil backLightsOn(Bil bil) {
        if (bil.running) {
            bil.backLightsOn = true;
        }
        return bil;
    }

    @Override
    public Bil backLightOff(Bil bil) {
        bil.backLifhtsOn = false;
        return bil;
    }

    @Override
    public Bil warningLifhtsOn(Bil bil) {
        bil.warningLightsOn = true;
        return bil;
    }

    @Override
    public Bil warningLightOff(Bil bil) {
        bil.warningLifhtsOn = false;
        return bil;
    }
}
