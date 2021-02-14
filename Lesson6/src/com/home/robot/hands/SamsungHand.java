package com.home.robot.hands;

public class SamsungHand extends Hand {

    public SamsungHand(int price) {
        super(price);
    }

    @Override
    public void upHand() {
        System.out.println("Samsung hand up");
    }
}
