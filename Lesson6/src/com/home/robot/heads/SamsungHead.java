package com.home.robot.heads;

public class SamsungHead extends Head{

    public SamsungHead(int price) {
        super(price);
    }

    @Override
    public void speak() {
        System.out.println("Samsung's head is speaking");
    }
}
