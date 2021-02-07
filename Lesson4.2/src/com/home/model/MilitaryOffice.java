package com.home.model;

import com.home.service.PersonsRegistry;

import java.util.LinkedList;
import java.util.List;

public class MilitaryOffice {
    private final PersonsRegistry registry;
    private List<MilitaryUnit> militaryUnit;

    public MilitaryOffice(PersonsRegistry registry) {
        this.registry = registry;
    }

    public MilitaryOffice(PersonsRegistry registry, List<MilitaryUnit> militaryUnit) {
        this.registry = registry;
        this.militaryUnit = militaryUnit;
    }

    public int getNumberOfRequiredRecruits() {
        int requiredNumberOfRecruits = 0;
        for (MilitaryUnit unit : militaryUnit) {
            requiredNumberOfRecruits += unit.getNumberOfFreePlaces();
        }
        return requiredNumberOfRecruits;
    }

    public List<Person> distributeRecruits(Address address) {
        List<Person> listOfMen = new LinkedList<>();
        for (Person person : registry.getListOfPeople(address)) {
            if (checkForSuitability(person)) {
                listOfMen.add(person);
            }
        }
        return listOfMen;
    }

    public void distributeRecruits(String country) {
        List<Person> listOfMen = new LinkedList<>();
        for (Person person : registry.getListOfPeople(country)) {
            if (checkForSuitability(person)) {
                listOfMen.add(person);
            }
        }
        for (Person recruit : listOfMen) {
            int freePlaces = 0;
            for (MilitaryUnit unit : militaryUnit) {        // distribution in units one by one
                if (unit.getNumberOfFreePlaces() > 0) {
                    unit.addNewRecruit(recruit);
                    break;
                }
            }
            for (MilitaryUnit unit : militaryUnit) {
                freePlaces = unit.getNumberOfFreePlaces();
            }
            if (freePlaces == 0) {
                System.out.println("All military units full");
                break;
            }

        }

    }

    public static boolean checkForSuitability(Person person) {
        int age = person.getAge();
        if (person.getGender().equals("male") && (age >= 18 && age <= 27)) {
            return true;
        } else {
            System.out.println(person.getName() + " is not suitable for service!");
            return false;
        }

    }

    public void listToString(List<Person> people, Address address) {
        System.out.println("List of men fit for military service in " + address.toString() + ": ");
        for (Person person : people) {
            System.out.print(person.getName() + ",");
        }
        System.out.println("\b");
        System.out.println("");
    }

}

