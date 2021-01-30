package com.home.model;

public class Person {

    private int age;
    private String name;
    private Address address;
    private String gender;


    public Person(int age, String name, Address address, String gender) {
        this.age = age;     // this - to global variable
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    public void info() {
        System.out.println("Hello, my name is " + name);
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
        this.age = Math.max(age, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
