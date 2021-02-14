package com.home.service;

import com.home.model.air.CivilPlane;
import com.home.model.air.MilitaryAircraft;
import com.home.model.ground.CargoVehicle;
import com.home.model.ground.Vehicle;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(100,240,2000,"BMW",10,
                "sedan",5);
        vehicle.calculateDistanceAtMaxSpeed();
        vehicle.printInfo();


        CargoVehicle cargoVehicle = new CargoVehicle(1000,120,15000,"Volvo",150);
        cargoVehicle.isLoaded();
        cargoVehicle.printInfo();


        CivilPlane civilPlane = new CivilPlane(20000,900,100000,"Boing",
                300,true);
        civilPlane.isLoaded();
        civilPlane.printInfo();


        MilitaryAircraft militaryAircraft = new MilitaryAircraft(200,700,25000,
                "Mig-22",true,100);
        militaryAircraft.shoot();
        militaryAircraft.catapulting();
        militaryAircraft.printInfo();



    }


}



