package com.home.robot.legs;

public class SonyLeg extends Leg{

    public SonyLeg(int price) {
        super(price);
    }

    @Override
    public void step() {
        System.out.println("Sony step");
    }
}
