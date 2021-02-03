package com.home.service;

import com.home.model.Computer;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer(Reader.readLine("CPU"), Reader.readLine("RAM"), Reader.readLine("Hard Disk"),
                Reader.readInt("Life Cycles"));
        computer.info();

        int lifeCycles = computer.getLifeCycle();

        while (lifeCycles > 0) {
            int cycle = computer.turnOn(lifeCycles);
            if (cycle > 0) {
                lifeCycles--;
            } else {
                lifeCycles = 0;
            }
        }


    }

}
