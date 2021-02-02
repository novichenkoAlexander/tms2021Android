package com.home.model;

import com.home.service.PersonsRegistry;

import java.util.LinkedList;
import java.util.List;

public class MilitaryOffice {
    PersonsRegistry registry;

    public MilitaryOffice(PersonsRegistry registry) {
        this.registry = registry;
    }

    public List<Person> getListOfHealthyMen(Address address) {
        List<Person> listOfMen = new LinkedList<>();
        for (Person person : registry.getListOfPeople(address)) {
            int age = person.getAge();
            checkForSuitability(listOfMen,person,age);
        }
        return listOfMen;
    }

    public List<Person> getListOfHealthyMen(String country) {
        List<Person> listOfMen = new LinkedList<>();
        for (Person person : registry.getListOfPeople(country)) {
            int age = person.getAge();
            checkForSuitability(listOfMen,person,age);
        }
        return listOfMen;
    }

    private static boolean checkForSuitability(List<Person> listOfMen,Person person, int age){
        if (person.getGender().equals("male") && (age >= 18 && age <= 27)) {
            listOfMen.add(person);
        }return true;
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

