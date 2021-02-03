package com.home.service;

import java.util.Scanner;

public class Reader {

    private static Scanner scanner;

    public static String readLine(String line) {
        System.out.println("Input info for " + line + " : ");
        scanner = new Scanner(System.in);
        line = scanner.nextLine();
        return line;
    }

    public static int readInt(String info) {
        System.out.println("Input number of " + info + ":");
        int intParam = 0;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                intParam = scanner.nextInt();
            }
            if (intParam > 0) {
                break;
            } else {
                System.out.println("Incorrect input!" + "\n" + "Input  again (number > 0):");
            }

        }
        return intParam;
    }

    public static int readInt() {
        int intParam = 0;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                intParam = scanner.nextInt();
            }
            if (intParam == 0 || intParam == 1) {
                break;
            } else {
                System.out.println("Incorrect input!" + "\n" + "Input  again (0 or 1):");
            }

        }
        return intParam;
    }
}
