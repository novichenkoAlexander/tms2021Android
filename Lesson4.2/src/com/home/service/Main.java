package com.home.service;

import com.home.exceptions.InvalidInfoInputException;
import com.home.model.Address;
import com.home.model.MilitaryOffice;
import com.home.model.MilitaryUnit;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;


public class Main {

    public static final String country = "Belarus";
    public static final String city = "Minsk";


    public static void main(String[] args) throws InvalidInfoInputException {

        /**
         * Creating people from console
         */
        /*
        Address countryAddress = new Address(country);
        Address allAddress = new Address(country, city);

*/
        /**
         * Hardcode creating people
         */
        Person oleg = new Person(20, "Oleg", "Ivanov", new Address("Belarus", "Minsk"), "male", 180);
        Person oleg1 = new Person(20, "Oleg", "Ivanov", new Address("Belarus", "Minsk"), "male", 180);
        Person alex = new Person(16, "Alex", "Novikov", new Address("Belarus", "Minsk"), "male", 170);
        Person ivan = new Person(25, "Ivan", "Suvorov", new Address("Belarus", "Minsk"), "male", 175);
        Person viktor = new Person(22, "Viktor", "Prokop", new Address("Belarus", "Grodno"), "male", 185);
        Person olga = new Person(23, "Olga", "Ivanova", new Address("Belarus", "Minsk"), "female", 165);
        Person vika = new Person(20, "Vika", "Li", new Address("Belarus", "Vitebsk"), "female", 177);
        Person pavel = new Person(30, "Pavel", "Borsch", new Address("Belarus", "Minsk"), "male", 175);
        Person max = new Person(26, "Max", "Korj", new Address("Belarus", "Minsk"), "male", 170);
        Person vlad = new Person(27, "Vlad", "Boev", new Address("Belarus", "Minsk"), "male", 170);
        Person vova = new Person(23, "Vova", "Nikitin", new Address("Belarus", "Minsk"), "male", 175);
        Person gena = new Person(22, "Gena", "Moh", new Address("Belarus", "Minsk"), "male", 170);
        Person peter = new Person(25, "Peter", "Pan", new Address("Belarus", "Minsk"), "male", 180);


        List<Person> listForRegistry = new LinkedList<>();
        listForRegistry.add(oleg);      ///
        listForRegistry.add(vova);
        listForRegistry.add(oleg1);     ///adding 2 equal person
        listForRegistry.add(alex);      // -
        listForRegistry.add(ivan);
        listForRegistry.add(viktor);
        listForRegistry.add(vika);      // -
        listForRegistry.add(olga);      // -
        listForRegistry.add(pavel);
        listForRegistry.add(max);
        listForRegistry.add(vlad);      // -
        listForRegistry.add(oleg);
        listForRegistry.add(gena);
        listForRegistry.add(peter);     //
        listForRegistry.add(peter);     //adding two equal links


        PersonsRegistry registry = new PersonsRegistry(listForRegistry);

        // Creating military units
        List<MilitaryUnit> listOfUnits = Util.createMilitaryUnit();

        // Creating military office
        MilitaryOffice office = new MilitaryOffice(registry, listOfUnits);
        office.distributeRecruits(country);

        System.out.println("\nThe list of recruits: \n");
        office.printRecruits();

//        /**
//         * Creating people, military office and units from console
//         */
//        PersonsRegistry registry = new PersonsRegistry(Util.createPeople());
//        List<MilitaryUnit> units = Util.createMilitaryUnit();
//        MilitaryOffice office = new MilitaryOffice(registry,units);
//        office.distributeRecruits(country);
//        office.printRecruits();

    }
}
