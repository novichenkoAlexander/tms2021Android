package com.home.robot.hands;

public class SonyHand extends Hand {

    public SonyHand(int price) {
        super(price);
    }

    @Override
    public void upHand() {
        System.out.println("Sony hand up");
    }
}
