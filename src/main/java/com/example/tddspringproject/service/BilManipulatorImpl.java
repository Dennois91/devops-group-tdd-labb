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

        bil = this.changeSpeed(bil, 0);
        bil = this.lightsOff(bil);
        bil.running = false;
        return bil;
    }

    @Override
    public Bil lightsOn(Bil bil) {

        bil = this.halfLightsOn(bil);
        bil = this.backLightsOn(bil);
        bil.lightsOn = true;
        return bil;
    }

    @Override
    public Bil lightsOff(Bil bil) {

        bil = this.halfLightsOff(bil);
        bil = this.fulLightsOff(bil);
        bil = this.backLightsOff(bil);
        bil.lightsOn = false;
        return bil;
    }

    @Override
    public Bil halfLightsOn(Bil bil) {
        if (bil.running && !bil.halfLightsOn) {
            bil.halfLightsOn = true;
            bil = this.fulLightsOff(bil);
            bil.batteryUsage += 1;
        }
        return bil;
    }

    @Override
    public Bil halfLightsOff(Bil bil) {
        if(bil.halfLightsOn){
            bil.halfLightsOn = false;
            bil.batteryUsage -= 2;
        }

        return bil;
    }

    @Override
    public Bil fulLightsOn(Bil bil) {
        if (bil.running && !bil.fullLightsOn) {
            bil.fullLightsOn = true;
            bil = this.halfLightsOff(bil);
            bil.batteryUsage += 2;
        }
        return bil;
    }

    @Override
    public Bil fulLightsOff(Bil bil) {

        if (bil.fullLightsOn) {
            bil.fullLightsOn = false;
            bil.batteryUsage -= 2;
        }

        return bil;
    }

    @Override
    public Bil backLightsOn(Bil bil) {
        if (bil.running && !bil.backLightsOn) {
            bil.backLightsOn = true;
            bil.batteryUsage += 1;
        }
        return bil;
    }

    @Override
    public Bil backLightsOff(Bil bil) {
        if(bil.backLightsOn){
            bil.backLightsOn = false;
            bil.batteryUsage -= 1;
        }

        return bil;
    }

    @Override
    public Bil warningLightsOn(Bil bil) {
        if(!bil.warningLightsOn){
            bil.warningLightsOn = true;
            bil.batteryUsage += 1;
        }

        return bil;
    }

    @Override
    public Bil warningLightsOff(Bil bil) {
        if(bil.warningLightsOn){
            bil.warningLightsOn = false;
            bil.batteryUsage -= 1;
        }

        return bil;
    }

    @Override
    public Bil changeSpeed(Bil bil, int speed) {
        if (speed <= 180 && speed >=0) {
            bil.speed = speed;
            bil = this.batteryUsage(bil, speed);
        }
        return bil;
    }

    @Override
    public Bil brake (Bil bil) {
        bil = this.changeSpeed(bil, 0);
        bil.brake = true;
        bil.brakeLight = true;
        return bil;
    }

    @Override
    public Bil releaseBrake (Bil bil) {
        bil.brake = false;
        bil.brakeLight = false;
        return bil;
    }

    @Override
    public Bil changeGear(Bil bil, int gear) {
        bil.gear = gear;
        return bil;
    }

    @Override
    public Bil drive(Bil bil) {
        bil = this.changeGear(bil, 1);
        return bil;
    }

    @Override
    public Bil reverse(Bil bil) {
        bil = this.changeGear(bil, -1);
        return bil;
    }

    @Override
    public Bil batteryLife(Bil bil, int life) {
        bil.batteryLife = life;
        return bil;
    }

    @Override
    public Bil batteryUsage(Bil bil, int usage) {
        bil.batteryUsage = usage;
        if (bil.batteryLife - usage > 0) {
            bil.batteryLife -= usage;
        } else {
            bil.batteryLife = 0;
        }

        return bil;
    }


}
