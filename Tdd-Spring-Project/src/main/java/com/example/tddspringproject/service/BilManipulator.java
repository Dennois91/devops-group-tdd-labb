package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;

public interface BilManipulator {
    Bil lightsOn (Bil bil);
    Bil lightsOff (Bil bil);

    Bil halfLifhtsOn (Bil bil);
    Bil halfLifhtsOff (Bil bil);

    Bil fullLifhtsOn (Bil bil);
    Bil fullLifhtsOff (Bil bil);

    Bil backLifhtsOn (Bil bil);
    Bil backLifhtsOff (Bil bil);

    Bil waringLifhtsOn (Bil bil);
    Bil waringLifhtsOff (Bil bil);

    Bil startCar(Bil testbil);
    Bil stopCar(Bil testbil);
}
