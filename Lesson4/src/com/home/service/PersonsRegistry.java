package com.home.service;

import com.home.model.Address;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;

public class PersonsRegistry {
    private Person[] citizens;
    private List<Person> persons;

    public PersonsRegistry(List<Person> persons) {
        this.persons = persons;
    }

    public PersonsRegistry(Person[] citizens) {
        this.citizens = citizens;
    }

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

    public void listToString(List<Person> people) {
        for (Person person : people) {
            System.out.print(person.getName() + ",");
        }
        System.out.println("\b");
        System.out.println("");
    }

}
