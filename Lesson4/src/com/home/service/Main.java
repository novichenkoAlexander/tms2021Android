package com.home.service;

import com.home.model.Address;
import com.home.model.MilitaryOffice;
import com.home.model.Person;

import java.util.List;


public class Main {

    public static final String country = "Belarus";
    public static final String city = "Minsk";


    public static void main(String[] args) {

        /**
         * Creating people from console
         */
        Address countryAddress = new Address(country);
        Address allAddress = new Address(country, city);


        PersonsRegistry registry = new PersonsRegistry(ConsoleInput.createPeople());
        System.out.println("Number of people living in " + country + " : " + registry.countPeople(country) + "\n");
        List<Person> people = registry.getListOfPeople(country);
        System.out.println("People living in " + country + " : ");
        registry.listToString(people);
        System.out.println("");

        System.out.println("Number of people living in " + country + "," + city + ": " +
                registry.countPeople(allAddress) + "\n");
        List<Person> people1 = registry.getListOfPeople(allAddress);
        System.out.println("People living in " + country + "," + city + " : ");
        registry.listToString(people1);
        System.out.println("");

        MilitaryOffice office = new MilitaryOffice(registry);

        /*
          List of healthy men in Belarus & Minsk
         */
        List<Person> listOfHealthyMen = office.getListOfHealthyMen(allAddress);
        office.listToString(listOfHealthyMen, allAddress);

        /*
          List of healthy men in whole Belarus
         */
        countryAddress.setCity("");
        listOfHealthyMen = office.getListOfHealthyMen(country);
        office.listToString(listOfHealthyMen, countryAddress);

    }
}
