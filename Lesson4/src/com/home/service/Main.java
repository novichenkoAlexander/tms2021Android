package com.home.service;

import com.home.model.Address;
import com.home.model.MilitaryOffice;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;


public class Main {

    public static final String country = "Belarus";
    public static final String city = "Minsk";


    public static void main(String[] args) {
//        Person ivan = new Person(26,"Ivan", new Address("Belarus", "Minsk"),"male");
//        Person alex = new Person(32,"Alex", new Address("Belarus", "Grodno"),"male");
//        Person peter = new Person(18,"Peter", new Address("Ukraine", "Kiev"),"male");
//        Person natalia = new Person(22,"Natalia", new Address("Belarus", "Minsk"),"female");
//        Person olga = new Person(22,"Olga", new Address("Russia", "Moscow"),"female");
//        Person oleg = new Person(20,"Oleg", new Address("Belarus", "Minsk"),"male");
//        Person pavel = new Person(27,"Pavel", new Address("Belarus", "Minsk"),"male");
//        Person denis = new Person(25,"Denis", new Address("Belarus", "Minsk"),"male");

        /**
         * Creating people from console
         */
        Address countryAddress = new Address(country);
        Address allAddress = new Address(country, city);

        PersonsRegistry registry = new PersonsRegistry(ConsoleInput.CreatePeople());
        System.out.println("Number of people living in " + country + " : " + registry.countPeople(country) + "\n");
        List<Person> people = registry.getListOfPeople(country);

        // TODO: Make right output of "They are"
        System.out.println("They are:");
        registry.listToString(people);
        System.out.println("");

        System.out.println("Number of people living in " + country + "," + city + ": " +
                registry.countPeople(allAddress) + "\n");
        List<Person> people1 = registry.getListOfPeople(allAddress);
        System.out.println("They are: ");
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


//        PersonsRegistry registry = new PersonsRegistry(new Person[]{ivan,alex,peter,natalia,olga,oleg,pavel,denis});
//        System.out.println("Number of people living in Belarus: " + registry.countPeople("Belarus"));
//
//
//        List<Person> people = registry.getListOfPeople(new Address("Belarus","Minsk"));
//        System.out.println("List of people living in Belarus, Minsk:");
//        registry.listToString(people);
//
//        MilitaryOffice office = new MilitaryOffice(registry);
//        List<Person>listOfHealthyMen = office.getListOfHealthyMen(new Address("Belarus","Minsk"));
//        office.listToString(listOfHealthyMen);
//        listOfHealthyMen = office.getListOfHealthyMen("Belarus");
//        office.listToString(listOfHealthyMen);


    }
}
