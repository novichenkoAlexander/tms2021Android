package com.home.service;

import com.home.model.Address;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ConsoleInput {

    /**
     * Read from console
     */
    private static Scanner scanner;

    public static Person readPerson() {
        System.out.println("Input age:");
        int age = readInt();
        System.out.println("Input name:");
        String name = readStringParam();
        System.out.println("Input country:");
        String country = readStringParam();
        System.out.println("Input city:");
        String city = readStringParam();
        System.out.println("Input gender:");
        String gender = readStringParam();

        return new Person(age, name, new Address(country, city), gender);
    }

    private static int readInt() {
        int intParam = 0;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                intParam = scanner.nextInt();
            }
            if (intParam > 0) {
                break;
            } else {
                System.out.println("Incorrect input!" + "\n" + "Input  again (int number > 0):");
            }

        }
        return intParam;
}

    private static String readStringParam() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static List<Person> CreatePeople() {
        System.out.println("Input number of people U would like to create:");
        int numberOfPeople = readInt();
        List<Person> people = new LinkedList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            people.add(ConsoleInput.readPerson());
            System.out.println("Input data for next person:");
        }
        return people;
    }


}


