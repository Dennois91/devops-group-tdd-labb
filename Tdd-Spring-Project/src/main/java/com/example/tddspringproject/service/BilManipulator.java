package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;

public interface BilManipulator {
    Bil lightsOn (Bil bil);
    Bil lightsOff (Bil bil);

    Bil halfLightsOn (Bil bil);
    Bil halfLightsOff (Bil bil);

    Bil fulLightsOn (Bil bil);
    Bil fulLightsOff (Bil bil);

    Bil backLightsOn (Bil bil);
    Bil backLightsOff (Bil bil);

    Bil warningLightsOn (Bil bil);
    Bil warningLightsOff (Bil bil);

    Bil startCar(Bil bil);
    Bil stopCar(Bil bil);

    Bil changeSpeed(Bil bil, int speed);

    Bil brake (Bil bil);

    Bil changeGear(Bil bil, int gear);
}
