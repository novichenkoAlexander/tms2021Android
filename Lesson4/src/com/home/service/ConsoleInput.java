package com.home.service;

import com.home.model.Address;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Class ConsoleInput includes methods to work with console
 */
public class ConsoleInput {

    private final static String[] countries = new String[]{"Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus",
            "Belgium", "Bosnia", "Bulgaria", "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France", "Georgia",
            "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Kosovo", "Latvia", "Liechtenstein", "Lithuania",
            "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway", "Poland", "Portugal",
            "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine",
            "United Kingdom", "Vatican City"};

    private static Scanner scanner;

    public static Person readPerson() {
        System.out.println("Input age:");
        int age = readInt();
        System.out.println("Input name:");
        String name = readString();
        System.out.println("Input country:");
        String country = readCountry();
        System.out.println("Input city:");
        String city = readString();
        System.out.println("Input gender:");
        String gender = readGender();

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
                System.out.println("Incorrect input!" + "\n" + "Input  again (number > 0):");
            }

        }
        return intParam;
    }

    private static String readString() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String readCountry() {
        String country = "";
        boolean countryFound = false;
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                country = scanner.nextLine();
                for (String element : countries) {
                    if (element.equals(country)) {
                        countryFound = true;
                        break;
                    }
                }
                if (countryFound) {
                    break;
                } else {
                    System.out.println("Incorrect country!" + "\nInput  again:");
                }
            }

        }
        return country;

    }

    private static String readGender() {
        String gender = "";
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                gender = scanner.nextLine();
            }
            if (gender.equals("male") || gender.equals("female")) {
                break;
            } else {
                System.out.println("Incorrect gender! \nInput" + "\" male\"" + " or " + "\" female\"");
            }
        }
        return gender;
    }

    public static List<Person> createPeople() {
        System.out.println("Input number of people You would like to enter:");
        int numberOfPeople = readInt();
        List<Person> people = new LinkedList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Input data of person:");
            people.add(ConsoleInput.readPerson());
        }
        return people;
    }


}


