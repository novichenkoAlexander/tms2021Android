package com.home.model;

import com.home.exceptions.InvalidInfoInputException;
import com.home.service.Util;

public class Person {

    private int age;
    private String name;
    private String lastName;
    private Address address;
    private String gender;
    private int height;


    public Person(int age, String name, String lastName, Address address, String gender) throws InvalidInfoInputException {
        this.age = age;
        this.name = Util.getFormattedString(name,"name");
        this.lastName = Util.getFormattedString(lastName,"lastName");
        this.address = address;
        this.gender = gender;
    }

    public Person(int age, String name, String lastName, Address address, String gender, int height) throws InvalidInfoInputException {
        this.age = age;
        this.name = Util.getFormattedString(name,"name");
        this.lastName = Util.getFormattedString(lastName,"lastName");
        this.address = address;
        this.gender = gender;
        this.height = height;
    }

    public void info() {
        System.out.println("Hello, I'm " + name + lastName);
        System.out.println("I`m " + age + " years old");
        System.out.println("I`m " + gender);
        System.out.println("I`m living in " + address.toString());
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Incorrect age");
        } else {
            //this.age = Math.max(age, 0);
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
