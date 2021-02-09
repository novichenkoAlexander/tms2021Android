package com.home.model.ground;

import com.home.model.Transport;
import com.home.model.ground.GroundTransport;

public class CargoTransport extends GroundTransport {
    private double loadCapacity;

    public CargoTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    @Override
    public String printInfo() {
        return "This cargo transport have load capacity of " + loadCapacity + "." + "Power is: " + getPowerInWatts() + " kW ";
    }

    @Override
    public double getPowerInWatts() {
        return getPower() * 0.74;

    }

}
