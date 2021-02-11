package com.home.model.air;

import com.home.service.Reader;

public class CivilPlane extends AirTransport {
    private int passengersCapacity;
    private boolean isBusinessClassAvailable;

    public CivilPlane(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    public CivilPlane(int power, double maxSpeed, double weight, String brand, int passengersCapacity, boolean isBusinessClassAvailable) {
        super(power, maxSpeed, weight, brand);
        this.passengersCapacity = passengersCapacity;
        this.isBusinessClassAvailable = isBusinessClassAvailable;
    }

    @Override
    public void printInfo() {
        if (isBusinessClassAvailable) {
            System.out.println("This plane has capacity of " + passengersCapacity +
                    " passengers and has business class seats. Power is : " + getPowerInWatts() + "kW");
        } else {
            System.out.println("This plane doesn't have business class seats. It can take " + passengersCapacity +
                    "passengers. " + "Power is:" + getPowerInWatts() + "kW");
        }
    }

    public boolean isLoaded() {
        System.out.println("Input number of passengers: ");
        Reader reader = new Reader();
        int passengers = reader.readInt();
        if (passengers <= passengersCapacity) {
            System.out.println("The plane is loaded with passengers!");
            return true;
        } else {
            System.out.println("You need a bigger plane!");
            return false;
        }
    }

}
