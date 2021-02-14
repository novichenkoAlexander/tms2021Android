package com.home.robot.legs;

public abstract class Leg implements ILeg{

    private final int price;

    public Leg(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
