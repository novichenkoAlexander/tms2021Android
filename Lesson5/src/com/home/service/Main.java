package com.home.service;

import com.home.model.air.AirTransport;
import com.home.model.ground.PassengerTransport;

public class Main {
    public static void main(String[] args) {

        PassengerTransport transport = new PassengerTransport(100,240,2000,"BMW",10);
        transport.calculateDistanceAtMaxSpeed();

    }


}



