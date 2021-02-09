package com.home.service;

import com.home.model.air.AirTransport;
import com.home.model.ground.CargoTransport;
import com.home.model.ground.PassengerTransport;

public class Main {
    public static void main(String[] args) {

        PassengerTransport transport = new PassengerTransport(100,240,2000,"BMW",10);
        transport.calculateDistanceAtMaxSpeed();

        CargoTransport cargoTransport = new CargoTransport(1000,120,15000,"Volvo",150);
        cargoTransport.isLoaded();

    }


}



