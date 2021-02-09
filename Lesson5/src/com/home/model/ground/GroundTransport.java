package com.home.model.ground;

import com.home.model.Transport;

public abstract class GroundTransport extends Transport {
    private int numberOfWheels;
    private double fuelFlow;    // litres/100 km

    public GroundTransport(int power, double maxSpeed, double weight, String brand, double fuelFlow) {
        super(power, maxSpeed, weight, brand);
        this.fuelFlow = fuelFlow;
    }

    public GroundTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public double getFuelFlow() {
        return fuelFlow;
    }

    public void setFuelFlow(double fuelFlow) {
        this.fuelFlow = fuelFlow;
    }
}
