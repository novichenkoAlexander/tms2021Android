package com.home.robot.hands;

public abstract class Hand implements IHand{

    private final int price;

    public Hand(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

}
