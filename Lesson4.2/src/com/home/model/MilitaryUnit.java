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

    public void addNewRecruit(Person person) {
        if (currentNumberOfRecruits < maxNumberOfRecruits) {
            if (MilitaryOffice.checkForSuitability(person) && checkForSimilarity(person)) {
                recruitList.add(person);
                currentNumberOfRecruits = recruitList.size();
            }
        } else {
            System.out.println("Military unit is full!");
        }
    }

    private boolean checkForSimilarity(Person person){
        if (recruitList.contains(person)){
            System.out.println("Recruit " + person.getName() + " is already serving!");
            return false;
        }else {
            return true;
        }
    }
    //TODO: check for same soldier in military unit!

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
