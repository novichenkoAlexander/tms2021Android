package com.home.model;

import com.home.exceptions.MilitaryUnitIsFullException;
import com.home.service.SortByLastName;

import java.util.LinkedList;
import java.util.List;

public class MilitaryUnit {

    private final int maxNumberOfRecruits;
    private int currentNumberOfRecruits;
    private final List<Person> recruitList;
    private final int unitId;

    public MilitaryUnit(int maxNumberOfRecruits, int unitId) {
        this.maxNumberOfRecruits = maxNumberOfRecruits;
        this.unitId = unitId;
        recruitList = new LinkedList<>();
    }

    public void addNewRecruit(Person person) throws MilitaryUnitIsFullException {
        if (currentNumberOfRecruits < maxNumberOfRecruits) {
            if (MilitaryOffice.isPersonSuitable(person) && !isSimilarRecruitExists(person)) {
                recruitList.add(person);
                currentNumberOfRecruits = recruitList.size();
                System.out.println(person.getName() + " " + person.getLastName() + " has been added to military unit № " +
                        unitId + "!");
            }
        } else {
            throw new MilitaryUnitIsFullException("Military unit is full!");
        }
    }

    private boolean isSimilarRecruitExists(Person person) {
        boolean check = false;
        if (recruitList.contains(person)) {
            check = true;
        } else {
            for (Person recruit : recruitList) {
                if (recruit.getName().equals(person.getName()) && recruit.getHeight() == person.getHeight()
                        && recruit.getAge() == person.getAge()) {
                    check = true;
                    break;
                }
            }

        }
        printState(person, check);
        return check;
    }

    private void printState(Person person, boolean check) {
        if (check)
            System.out.println("Recruit " + person.getName() + " " + person.getLastName() + " is already serving in this Unit!");
    }

    public int getNumberOfFreePlaces() {
        return maxNumberOfRecruits - currentNumberOfRecruits;
    }

    public List<Person> getListOfRecruits() {
        return recruitList;
    }

    public void printRecruitsInfo() {
        recruitList.sort(new SortByLastName());
        System.out.println("Military unit № " + unitId + ":");
        for (Person recruit : recruitList) {
            System.out.println(recruit.getName() + " "
                    + recruit.getLastName() + ", "
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

    public int getUnitId() {
        return unitId;
    }
}
