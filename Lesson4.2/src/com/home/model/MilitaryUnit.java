package com.home.model;

import java.util.LinkedList;
import java.util.List;

public class MilitaryUnit {

    private final int maxNumberOfRecruits;
    private int currentNumberOfRecruits;
    private final List<Person> recruitList;

    public MilitaryUnit(int maxNumberOfRecruits) {
        this.maxNumberOfRecruits = maxNumberOfRecruits;
        recruitList = new LinkedList<>();
    }

    public void addNewRecruit(Person person) throws MilitaryUnitIsFullException {
        if (currentNumberOfRecruits < maxNumberOfRecruits) {
            if (MilitaryOffice.isPersonSuitable(person) && isSimilarRecruitExists(person)) {
                recruitList.add(person);
                currentNumberOfRecruits = recruitList.size();
                System.out.println(person.getName() + " has been added to Military Unit!");
            }
        } else {
            //System.out.println("Military unit is full!");
            throw new MilitaryUnitIsFullException("Military unit is full!");
        }
    }

    private boolean isSimilarRecruitExists(Person person) {
        boolean check = true;
        if (recruitList.contains(person)) {
            check = false;
        } else {
            for (Person recruit : recruitList) {
                if (recruit.getName().equals(person.getName()) && recruit.getHeight() == person.getHeight()
                        && recruit.getAge() == person.getAge()) {
                    check = false;
                    break;
                }
            }

        }
        printState(person, check);
        return check;
    }

    private void printState(Person person, boolean check) {
        if (!check)
            System.out.println("Recruit " + person.getName() + " is already serving in this Unit!");
    }

    public int getNumberOfFreePlaces() {
        return maxNumberOfRecruits - currentNumberOfRecruits;
    }

    public List<Person> getListOfRecruits() {
        return recruitList;
    }

    public void printAllRecruits() {
        for (Person recruit : recruitList) {
            System.out.println(recruit.getName() + ", "
                    + recruit.getAge() + " years, "
                    + recruit.getHeight() + " cm");
        }
    }

    public int getMaxNumberOfRecruits() {
        return maxNumberOfRecruits;
    }

    public int getCurrentNumberOfRecruits() {
        return currentNumberOfRecruits;
    }
}
