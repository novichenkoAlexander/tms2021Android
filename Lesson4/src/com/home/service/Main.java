package com.home.service;
import com.home.model.Address;
import com.home.model.MilitaryOffice;
import com.home.model.Person;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Person ivan = new Person(26,"Ivan", new Address("Belarus", "Minsk"),"male");
        Person alex = new Person(32,"Alex", new Address("Belarus", "Grodno"),"male");
        Person peter = new Person(18,"Peter", new Address("Ukraine", "Kiev"),"male");
        Person natalia = new Person(22,"Natalia", new Address("Belarus", "Minsk"),"female");
        Person olga = new Person(22,"Olga", new Address("Russia", "Moscow"),"female");
        Person oleg = new Person(20,"Oleg", new Address("Belarus", "Minsk"),"male");
        Person pavel = new Person(27,"Pavel", new Address("Belarus", "Minsk"),"male");
        Person denis = new Person(25,"Denis", new Address("Belarus", "Minsk"),"male");

        PersonsRegistry registry = new PersonsRegistry(new Person[]{ivan,alex,peter,natalia,olga,oleg,pavel,denis});
        System.out.println("Number of people living in Belarus: " + registry.countPeople("Belarus"));

        List<Person> people = registry.getListOfPeople(new Address("Belarus","Minsk"));
        System.out.println("List of people living in Belarus, Minsk:");
        registry.listToString(people);

        MilitaryOffice office = new MilitaryOffice(registry);
        List<Person>listOfHealthyMen = office.getListOfHealthyMen(new Address("Belarus","Minsk"));
        office.listToString(listOfHealthyMen);
        listOfHealthyMen = office.getListOfHealthyMen("Belarus");
        office.listToString(listOfHealthyMen);
    }
}
