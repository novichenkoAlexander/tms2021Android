package com.home.service;

import java.util.Scanner;

public class Reader implements Readable{

    private Scanner scanner;

    @Override
    public double readDouble() {
        double input = 0;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
            }
            if (input > 0) {
                break;
            } else {
                System.out.println("Incorrect input!" + "\n" + "Input  again (number > 0):");
            }

        }
        return input;
    }

    @Override
    public int readInt() {
        int input = 0;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            }
            if (input > 0) {
                break;
            } else {
                System.out.println("Incorrect input!" + "\n" + "Input  again (number > 0):");
            }

        }
        return input;
    }


}
