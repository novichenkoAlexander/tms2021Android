package com.home.robot.heads;

public class ToshibaHead extends Head{
    private int price;

    public ToshibaHead(int price) {
        super(price);
    }

    @Override
    public void speak() {
        System.out.println("Toshiba's head is speaking");
    }

}
