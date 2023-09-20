package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;

public interface BilManipulator {
    Bil lightsOn (Bil bil);
    Bil lightsOff (Bil bil);

    Bil halfLightsOn (Bil bil);
    Bil halfLightsOff (Bil bil);

    Bil fullLightsOn (Bil bil);
    Bil fullLightsOff (Bil bil);

    Bil backLightsOn (Bil bil);
    Bil backLightsOff (Bil bil);

    Bil waringLightsOn (Bil bil);
    Bil waringLightsOff (Bil bil);

    Bil startCar(Bil testbil);
    Bil stopCar(Bil testbil);
}
