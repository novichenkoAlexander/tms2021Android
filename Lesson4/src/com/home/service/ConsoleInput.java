package com.home.service;

import com.home.model.Address;
import com.home.model.Person;

import java.util.Scanner;


public class ConsoleInput {
    public static void main(String[] args) {


    }

    /**
     * Read from console
     */
    private static Scanner scanner;

    public static Person readPerson() {
        System.out.println("Input age:");
        int age = readAge();
        System.out.println("Input name:");
        String name = readStringParam();
        System.out.println("Input country:");
        String country = readStringParam();
        System.out.println("Input city:");
        String city = readStringParam();
        System.out.println("Input gender:");
        String gender = readStringParam();

        return new Person(age,name,new Address(country,city),gender);
    }

    private static int readAge() {
        int age;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                break;
            } else {
                System.out.println("Incorrect input!");
                System.out.println("Input age again:");
            }
        }
        return age;
    }

    private static String readStringParam() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}


