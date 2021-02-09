package com.home.model.air;

public class MilitaryTransport extends AirTransport {
    private boolean isEjectionSystemAvailable;
    private int missiles;

    public MilitaryTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    @Override
    public double getPowerInWatts() {
        return getPower() * 0.74;
    }

    @Override
    public void printInfo() {
        System.out.println("The power is: " + getPowerInWatts() + "kW");
        if (isEjectionSystemAvailable) {
            System.out.println("Pilot can eject.");
        }
        if (missiles != 0) {
            System.out.println("This transport has " + missiles + " missiles on board");
        }
        System.out.println("No missiles on board.");
    }
}
