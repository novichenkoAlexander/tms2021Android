package com.home.model;

import com.home.exceptions.MilitaryUnitIsFullException;
import com.home.service.PersonsRegistry;

import java.util.LinkedList;
import java.util.List;

public class MilitaryOffice {
    private final PersonsRegistry registry;
    private final List<MilitaryUnit> militaryUnits;


    public MilitaryOffice(PersonsRegistry registry, List<MilitaryUnit> militaryUnits) {
        this.registry = registry;
        this.militaryUnits = militaryUnits;
    }

    public int getNumberOfRequiredRecruits() {
        int requiredNumberOfRecruits = 0;
        for (MilitaryUnit unit : militaryUnits) {
            requiredNumberOfRecruits += unit.getNumberOfFreePlaces();
        }
        return requiredNumberOfRecruits;
    }

    public List<Person> distributeRecruits(Address address) {
        return filterPeopleBySuitability(registry.getListOfPeople(address));
    }

    public void distributeRecruits(String country) {
        List<Person> listOfMen = filterPeopleBySuitability(registry.getListOfPeople(country));
        int unitNumber = 0;
        for (Person recruit : listOfMen) {
            int freePlaces = 0;
            //int unitNumber = 0;
            for (int i = unitNumber; i < militaryUnits.size(); i++) {        // distribution in units one by one
                try {
                    militaryUnits.get(i).addNewRecruit(recruit);
                    break;
                } catch (MilitaryUnitIsFullException e) {
                    e.printStackTrace();
                    unitNumber++;
                }
            }
            for (MilitaryUnit unit : militaryUnits) {
                freePlaces += unit.getNumberOfFreePlaces();
            }
            if (freePlaces == 0) {
                System.out.println("All military units are full!");
                break;
            }

        }

    }

    private List<Person> filterPeopleBySuitability(List<Person> people) {
        List<Person> listOfMen = new LinkedList<>();
        for (Person person : people) {
            if (isPersonSuitable(person)) {
                listOfMen.add(person);
            }
        }
        return listOfMen;
    }

    public static boolean isPersonSuitable(Person person) {
        int age = person.getAge();
        if (person.getGender().equals("male") && (age >= 18 && age < 27)) {
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

    public void printRecruits() {
        for (MilitaryUnit unit : militaryUnits) {
            unit.printRecruitsInfo();
            System.out.println("\n");
        }
    }

}

