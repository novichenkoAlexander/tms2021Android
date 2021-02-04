package com.home.service;

import com.home.model.Computer;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer(Reader.readLine("CPU"), Reader.readLine("RAM"), Reader.readLine("Hard Disk"),
                Reader.readInt("Life Cycles"));
        computer.info();

        computer.turnOn();
        computer.turnOff();
        computer.turnOn();
    }
}

