package com.home.model;

import com.home.service.Reader;

import java.util.Random;

public class Computer {

    private String cpu;
    private String ram;
    private String hardDisk;
    private int lifeCycle;

    public Computer(String cpu, String ram, String hardDisk, int lifeCycle) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.lifeCycle = lifeCycle;
    }

    public void info() {
        System.out.println("Model of CPU: " + cpu);
        System.out.println("Model of RAM: " + ram);
        System.out.println("Model of hard disk: " + hardDisk);
        System.out.println("Number of life cycle: " + lifeCycle);
    }

    public void turnOn() {
        if (cycleCounter < lifeCycle) {
            if (status == 2) {                  // 2 - pc is Off
                if (lifeCycle == 0) {
                    System.out.println("PC has burned down! Out of life cycles! ");
                    setStatus(0);
                } else {
                    System.out.println("PC is turning on...");
                    if (getRandomNumber()) {
                        System.out.println("PC is ON!");
                        setStatus(1);
                    } else {
                        System.out.println("PC has burned down!!!");
                        setStatus(0);
                    }
                }
            }
            if (status == 0) {
                System.out.println("PC has burned down!!!");
                setStatus(0);
            }
        } else {
            System.out.println("PC has burned down! Out of life cycles! ");
            setStatus(0);
        }
        return state;

    }

    public void turnOff() {
        if (status == 1) {      // PC is on
            System.out.println("PC is turning off...");
            if (getRandomNumber()) {
                System.out.println("PC is OFF!");
            } else {
                System.out.println("PC has burned down!!!");
                setStatus(0);
            }
        }

    }

    private boolean getRandomNumber() {
        Random random = new Random();
        int oneZero = random.nextInt(2);
        System.out.println("ALARM! Input 0 or 1");
        int check = Reader.readInt();
        return oneZero == check;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public int getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(int lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
}
