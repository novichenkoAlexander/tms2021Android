package com.home.service;

import com.home.model.Address;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;

public class PersonsRegistry {
    //private Person[] citizens;
    private final List<Person> citizens;

    public PersonsRegistry(List<Person> citizens) {
        this.citizens = citizens;
    }

//    public PersonsRegistry(Person[] citizens) {
//        this.citizens = citizens;
//    }

    public int countPeople(Address address) {
        int numberOfPeople = 0;
        for (Person person : citizens) {
            if (person.getAddress().getCountry().equals(address.getCountry())
                    && person.getAddress().getCity().equals(address.getCity())) {
                numberOfPeople++;
            }
        }
        return numberOfPeople;
    }

    public int countPeople(String country) {
        int numberOfPeople = 0;
        for (Person person : citizens) {
            if (person.getAddress().getCountry().equals(country)) {
                numberOfPeople++;
            }
        }
        return numberOfPeople;
    }

    public List<Person> getListOfPeople(Address address) {
        List<Person> people = new LinkedList<>();
        for (Person person : citizens) {
            if (person.getAddress().getCountry().equals(address.getCountry())
                    && person.getAddress().getCity().equals(address.getCity())) {
                people.add(person);
            }

        }
        return people;
    }

    public List<Person> getListOfPeople(String country) {
        List<Person> people = new LinkedList<>();
        for (Person person : citizens) {
            if (person.getAddress().getCountry().equals(country)) {
                people.add(person);
            }

        }
        return people;
    }

    public void listToString(List<Person> personList) {
        String string = "";
        for (Person person : personList) {
            string = person.getName();
            System.out.println(person.getName());
        }

    }

}
