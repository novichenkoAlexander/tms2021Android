package com.home.model.ground;

import com.home.service.Reader;

public class PassengerTransport extends GroundTransport {
    private String bodyStyle;
    private int passengers;

    public PassengerTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    public PassengerTransport(int power, double maxSpeed, double weight, String brand, double fuelFlow) {
        super(power, maxSpeed, weight, brand, fuelFlow);
    }

    public PassengerTransport(int power, double maxSpeed, double weight, String brand, double fuelFlow, String bodyStyle, int passengers) {
        super(power, maxSpeed, weight, brand, fuelFlow);
        this.bodyStyle = bodyStyle;
        this.passengers = passengers;
    }

    @Override
    public String printInfo() {
        return "This is passenger transport with " + bodyStyle + "body style. \n" +
                "It can take " + passengers + " passengers. \n" +
                "It has power of: " + getPowerInWatts() + " kW ";
    }

    @Override
    public double getPowerInWatts() {
        return getPower() * 0.74;
    }

    public void calculateDistanceAtMaxSpeed() {
        double distance = 0;
        double maxSpeed = getMaxSpeed();
        Reader reader = new Reader();
        System.out.println("Input time in hours: ");
        double time = reader.readDouble();
        distance = maxSpeed * time;
        System.out.println("For the time of " + time + " h " + getBrand() + " car moving at maximum speed of " + maxSpeed +
                " km/h will pass " + distance + " km and use up " + getConsumedFuel(distance) + " litres of fuel");
    }

    private double getConsumedFuel(double distance) {
        return distance / 100 * getFuelFlow();
    }
}
