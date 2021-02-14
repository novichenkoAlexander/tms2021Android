package com.home.robot.heads;

public abstract class Head implements IHead {
    private final int price;

    public Head(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
