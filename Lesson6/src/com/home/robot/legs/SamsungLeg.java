package com.home.robot.legs;

public class SamsungLeg extends Leg{

    public SamsungLeg(int price) {
        super(price);
    }

    @Override
    public void step() {
        System.out.println("Samsung step");
    }
}
