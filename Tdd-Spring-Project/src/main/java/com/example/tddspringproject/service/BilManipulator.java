package com.example.tddspringproject.service;

import com.example.tddspringproject.model.Bil;

public interface BilManipulator {

    Bil lightOn (Bil bil);

    Bil lightOff (Bil bil);

    Bil startCar(Bil testbil);

    Bil stopCar(Bil testbil);
}
