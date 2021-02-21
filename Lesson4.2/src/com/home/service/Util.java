package com.home.service;

import com.home.exceptions.InvalidInfoInputException;
import com.home.model.Address;
import com.home.model.MilitaryUnit;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Util includes methods to work with console and other encapsulated logics
 */
public class Util {

    private final static String[] countries = new String[]{"Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus",
            "Belgium", "Bosnia", "Bulgaria", "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France", "Georgia",
            "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Kosovo", "Latvia", "Liechtenstein", "Lithuania",
            "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway", "Poland", "Portugal",
            "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine",
            "United Kingdom", "Vatican City"};

    private static Scanner scanner;

    public static Person readPerson() throws InvalidInfoInputException {
        System.out.println("Input age:");
        int age = readInt();
        System.out.println("Input name:");
        String name = readString("name");
        System.out.println("Input lastName:");
        String lastName = readString("lastname");
        System.out.println("Input country:");
        String country = readCountry();
        System.out.println("Input city:");
        String city = readString("city");
        System.out.println("Input gender:");
        String gender = readGender();
        System.out.println("Input height (in cm): ");
        int height = readInt();

        return new Person(age, name, lastName, new Address(country, city), gender, height);
    }

    /**
     * This method return string in formatted view.
     *
     * @param info - String name or latsName or smth else
     * @param flag - String parameter to define input info
     * @return formatted string
     * @throws InvalidInfoInputException
     */
    public static String getFormattedString(String info, String flag) throws InvalidInfoInputException {
        String string = info.trim();
        if (!string.isEmpty() && !string.contains(" ")) {
            string = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
        } else {
            throw new InvalidInfoInputException("Invalid input " + flag + "!");
        }
        return string;
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

    private static String readString(String s) throws InvalidInfoInputException {
        scanner = new Scanner(System.in);
        return getFormattedString(scanner.nextLine(), s);
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

    public static List<Person> createPeople() throws InvalidInfoInputException {
        System.out.println("Input number of people You would like to enter:");
        int numberOfPeople = readInt();
        List<Person> people = new LinkedList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Input data of person:");
            people.add(Util.readPerson());
        }
        return people;
    }

    /**
     * This method returns the list of MilitaryUnits created from console
     */
    public static List<MilitaryUnit> createMilitaryUnit() {
        System.out.println("Input number of military units: ");
        int numberOfUnits = readInt();
        List<MilitaryUnit> units = new LinkedList<>();
        for (int i = 0; i < numberOfUnits; i++) {
            System.out.println("Input military unit id: ");
            int unitId = readInt();
            System.out.println("Input max number of recruits in this unit: ");
            int unitCapacity = readInt();
            units.add(new MilitaryUnit(unitCapacity, unitId));
        }
        return units;
    }


}


