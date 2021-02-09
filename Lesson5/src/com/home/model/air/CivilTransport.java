package com.home.model.air;

public class CivilTransport extends AirTransport {
    private int passengers;
    private boolean isBusinessClassAvailable;

    public CivilTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    @Override
    public double getPowerInWatts() {
        return getPower() * 0.74;
    }

    @Override
    public String printInfo() {
        if (isBusinessClassAvailable) {
            return "This air transport has capacity of " + passengers + "and has business class seats. Power is : " +
                    +getPowerInWatts() + "kW";
        } else
            return "This air transport doesn't have business class seats. It can take " + passengers + "passengers. " +
                    "Power is:" + getPowerInWatts() + "kW";
    }

}
