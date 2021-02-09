package com.home.service;

import com.home.model.air.AirTransport;
import com.home.model.air.CivilTransport;
import com.home.model.ground.CargoTransport;
import com.home.model.ground.PassengerTransport;

public class Main {
    public static void main(String[] args) {

//        PassengerTransport passengerTransport = new PassengerTransport(100,240,2000,"BMW",10,
//                "sedan",5);
//        passengerTransport.calculateDistanceAtMaxSpeed();
//        passengerTransport.printInfo();
//

//        CargoTransport cargoTransport = new CargoTransport(1000,120,15000,"Volvo",150);
//        cargoTransport.isLoaded();
//        cargoTransport.printInfo();


        CivilTransport civilTransport = new CivilTransport(20000,900,100000,"Boing",
                300,true);
        civilTransport.isLoaded();
        civilTransport.printInfo();

    }


}



