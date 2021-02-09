package com.home.model.air;

import com.home.model.Transport;

public abstract class AirTransport extends Transport {
    private double wingspan;
    private double minRunwayLength;

    public AirTransport(int power, double maxSpeed, double weight, String brand) {
        super(power, maxSpeed, weight, brand);
    }



}
