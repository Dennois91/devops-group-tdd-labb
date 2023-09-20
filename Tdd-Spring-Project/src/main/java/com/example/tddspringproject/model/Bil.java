package com.example.tddspringproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bil {

    public boolean running;
    public boolean lightsOn;
    public boolean fullLightsOn;
    public boolean halfLightsOn;
    public boolean backLightsOn;
    public boolean warningLightsOn;
    public boolean brake;
    public boolean brakeLight;
    public int batteryLife;
    public int batteryUsage;
    public int speed;
    public int gear;
}
