package com.home.robot.legs;

public class ToshibaLeg extends Leg{

    public ToshibaLeg(int price) {
        super(price);
    }

    @Override
    public void step() {
        System.out.println("Toshiba step");
    }
}
