package com.home.model.air;

public class MilitaryAircraft extends AirTransport {
    private boolean isEjectionSystemAvailable;
    private int missiles;

    public MilitaryAircraft(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }

    public MilitaryAircraft(int power, double maxSpeed, double weight, String brand, boolean isEjectionSystemAvailable, int missiles) {
        super(power, maxSpeed, weight, brand);
        this.isEjectionSystemAvailable = isEjectionSystemAvailable;
        this.missiles = missiles;
    }

    @Override
    public void printInfo() {
        System.out.println("The power is: " + getPowerInWatts() + "kW");
        if (isEjectionSystemAvailable) {
            System.out.println("Pilot can eject.");
        }
        if (missiles != 0) {
            System.out.println("This transport has " + missiles + " missiles on board");
        }else {
            System.out.println("No missiles on board.");
        }

    }

    public void shoot(){
        if (missiles == 0){
            System.out.println("No missiles available");
        }else {
            System.out.println("Missile away!");
            missiles--;
        }
    }

    public boolean catapulting(){
        if (isEjectionSystemAvailable){
            System.out.println("The ejection was successful!");
            return true;
        }else {
            System.out.println("You don't have ejection system!");
            return false;
        }
    }

}
