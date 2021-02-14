package com.home.service;

import com.home.model.Address;
import com.home.model.MilitaryOffice;
import com.home.model.MilitaryUnit;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;


public class Main {

    public static final String country = "Belarus";
    public static final String city = "Minsk";


    public static void main(String[] args) throws MilitaryUnitIsFullException {

        /**
         * Creating people from console
         */
        /*
        Address countryAddress = new Address(country);
        Address allAddress = new Address(country, city);

        /*
            Creating list of people
         */
/*        PersonsRegistry registry = new PersonsRegistry(ConsoleInput.createPeople());
        System.out.println("Number of people living in " + country + " : " + registry.countPeople(country) + "\n");
        List<Person> people = registry.getListOfPeople(country);
        System.out.println("People living in " + country + " : ");
        registry.listToString(people);

        System.out.println("Number of people living in " + country + "," + city + ": " +
                registry.countPeople(allAddress) + "\n");
        List<Person> people1 = registry.getListOfPeople(allAddress);
        System.out.println("People living in " + country + "," + city + " : ");
        registry.listToString(people1);
*/
        /**
         * Hardcode creating people
         */
        Person oleg = new Person(20, "Oleg", new Address("Belarus", "Minsk"), "male", 180);
        Person oleg1 = new Person(20, "Oleg", new Address("Belarus", "Minsk"), "male", 180);
        Person alex = new Person(16, "Alex", new Address("Belarus", "Minsk"), "male", 170);
        Person ivan = new Person(25, "Ivan", new Address("Belarus", "Minsk"), "male", 175);
        Person viktor = new Person(22, "Viktor", new Address("Belarus", "Grodno"), "male", 185);
        Person olga = new Person(23, "Olga", new Address("Belarus", "Minsk"), "female", 165);
        Person vika = new Person(20, "Vika", new Address("Belarus", "Vitebsk"), "female", 177);
        Person pavel = new Person(30, "Pavel", new Address("Belarus", "Minsk"), "male", 175);
        Person max = new Person(26, "Max", new Address("Belarus", "Minsk"), "male", 170);
        Person vlad = new Person(27, "Vlad", new Address("Belarus", "Minsk"), "male", 170);
        Person vova = new Person(23, "Vova", new Address("Belarus", "Minsk"), "male", 175);
        Person gena = new Person(22, "Gena", new Address("Belarus", "Minsk"), "male", 170);
        Person peter = new Person(25, "Peter", new Address("Belarus", "Minsk"), "male", 180);


        List<Person> listForRegistry = new LinkedList<>();
        listForRegistry.add(oleg);      //
        listForRegistry.add(vova);
        listForRegistry.add(oleg1);     //adding 2 equal person
        listForRegistry.add(alex);
        listForRegistry.add(ivan);
        listForRegistry.add(viktor);
        listForRegistry.add(vika);
        listForRegistry.add(olga);
        listForRegistry.add(pavel);
        listForRegistry.add(max);
        listForRegistry.add(vlad);
        listForRegistry.add(oleg);
        listForRegistry.add(gena);
        listForRegistry.add(peter);     //
        listForRegistry.add(peter);     //adding two equal links


        PersonsRegistry registry = new PersonsRegistry(listForRegistry);

        // Creating military units
        List<MilitaryUnit> listOfUnits = ConsoleInput.createMilitaryUnit();

        // Creating military office
        MilitaryOffice office = new MilitaryOffice(registry, listOfUnits);
        office.distributeRecruits(country);

        System.out.println("\nThe list of recruits: \n");
        for (MilitaryUnit unit : listOfUnits) {
            unit.printAllRecruits();
            System.out.println("");
        }

    }
}
