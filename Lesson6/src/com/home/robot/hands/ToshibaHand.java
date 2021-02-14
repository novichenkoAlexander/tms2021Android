package com.home.robot.hands;

public class ToshibaHand extends Hand {

    public ToshibaHand(int price) {
        super(price);
    }

    @Override
    public void upHand() {
        System.out.println("Toshiba hand up");
    }
}
