package com.home.robot.heads;

public class SonyHead extends Head {
    private int price;

    public SonyHead(int price) {
        super(price);
    }

    @Override
    public void speak() {
        System.out.println("Sony's head is speaking");
    }

}
