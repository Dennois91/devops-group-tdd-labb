package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;
import org.springframework.stereotype.Service;

@Service
public class BilManipulatorImpl implements BilManipulator {
    @Override
    public Bil startCar(Bil bil) {
        bil.running = true;
        bil = this.changeSpeed(bil, 0);
        return bil;
    }

    @Override
    public Bil stopCar(Bil bil) {
        bil.running = false;
        bil = this.changeSpeed(bil, 0);
        bil = this.lightsOff(bil);
        return bil;
    }

    @Override
    public Bil lightsOn(Bil bil) {
        bil.lightsOn = true;
        bil = this.halfLightsOn(bil);
        bil = this.backLightsOn(bil);
        return bil;
    }

    @Override
    public Bil lightsOff(Bil bil) {
        bil.lightsOn = false;
        bil = this.halfLightsOff(bil);
        bil = this.fulLightsOff(bil);
        bil = this.backLightsOff(bil);
        return bil;
    }

    @Override
    public Bil halfLightsOn(Bil bil) {
        if (bil.running) {
            bil.halfLightsOn = true;
            bil = this.fulLightsOff(bil);
        }
        return bil;
    }

    @Override
    public Bil halfLightsOff(Bil bil) {
        bil.halfLightsOn = false;
        return bil;
    }

    @Override
    public Bil fulLightsOn(Bil bil) {
        if (bil.running) {
            bil.fullLightsOn = true;
            bil = this.halfLightsOff(bil);
        }
        return bil;
    }

    @Override
    public Bil fulLightsOff(Bil bil) {
        bil.fullLightsOn = false;
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
    public Bil backLightsOff(Bil bil) {
        bil.backLightsOn = false;
        return bil;
    }

    @Override
    public Bil warningLightsOn(Bil bil) {
        bil.warningLightsOn = true;
        return bil;
    }

    @Override
    public Bil warningLightsOff(Bil bil) {
        bil.warningLightsOn = false;
        return bil;
    }

    @Override
    public Bil changeSpeed(Bil bil, int speed) {
        if (speed <= 180 && speed >=0) {
            bil.speed = speed;
        }
        return bil;
    }

    @Override
    public Bil brake (Bil bil) {
        bil = this.changeSpeed(bil, 0);
        return bil;
    }

    @Override
    public Bil changeGear(Bil bil, int gear) {
        bil.gear = gear;
        return bil;
    }


}
