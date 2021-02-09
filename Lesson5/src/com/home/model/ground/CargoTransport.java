package com.home.model.ground;

import com.home.service.Reader;

public class CargoTransport extends GroundTransport {
    private double loadCapacity; // in tonnes

    public CargoTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    public CargoTransport(int power, double maxSpeed, double weight, String brand, double loadCapacity) {
        super(power, maxSpeed, weight, brand);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void printInfo() {
        System.out.println("This cargo transport have load capacity of " + loadCapacity + "." + "Power is: " + getPowerInWatts()
                + " kW ");
    }

    @Override
    public double getPowerInWatts() {
        return getPower() * 0.74;
    }

    public boolean isLoaded(){
        System.out.println("Input mass of cargo in tonnes: ");
        Reader reader = new Reader();
        double cargo = reader.readDouble();
        if(cargo <= loadCapacity){
            System.out.println("The truck is loaded!");
            return true;
        }else {
            System.out.println("You need a bigger truck!");
            return false;
        }
    }


}
