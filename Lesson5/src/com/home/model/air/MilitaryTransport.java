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
    public String printInfo() {
        System.out.println("The power is: " + getPowerInWatts() + "kW");
        if (isEjectionSystemAvailable) {
            return "Pilot can eject.";
        }
        if (missiles != 0) {
            return "This transport has " + missiles + " missiles on board";
        }
        return "No missiles on board.";
    }
}
