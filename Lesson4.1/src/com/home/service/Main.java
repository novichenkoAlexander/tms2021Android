package com.home.service;

import com.home.model.Computer;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer(Reader.readLine("CPU"), Reader.readLine("RAM"), Reader.readLine("Hard Disk"),
                Reader.readInt("Life Cycles"));
        computer.info();

        int lifeCycles = computer.getLifeCycle();

        while (lifeCycles >= 0) {
            boolean isDead = false;
            isDead = computer.turnOn(lifeCycles, isDead);
            isDead = computer.turnOff(isDead);
            lifeCycles--;
            if (isDead) {
                break;
            }
        }
    }
}

