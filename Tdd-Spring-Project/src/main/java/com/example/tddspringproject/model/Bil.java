package com.example.tddspringproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bil {

    public boolean lightsOn;
    public boolean fullLight = true;
    public boolean halfLights = true;
    public boolean backLights = true;
    public boolean running;
}
