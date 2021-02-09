package com.home.model;

public abstract class Transport {
    /**
     * power - in horsepower
     * maxSpeed - in km/h
     * weight - in kg
     * brand (fot ins.: Audi, BMW, Boing)
     */
    private final int power;
    private final double maxSpeed;
    private final double weight;
    private final String brand;

    public Transport(int power, double maxSpeed, double weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    public abstract double getPowerInWatts();

    public abstract void printInfo();

    public int getPower() {
        return power;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }
}
