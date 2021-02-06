package com.home.model;

import java.util.LinkedList;
import java.util.List;

public class MilitaryUnit {
    private int maxNumberOfSoldiers;
    private int currentNumberOfSoldiers;
    private List<Person>recruitList = new LinkedList<>();

    public MilitaryUnit(int maxNumberOfSoldiers) {
        this.maxNumberOfSoldiers = maxNumberOfSoldiers;
    }

    public void addNewRecruit(Person person){
        currentNumberOfSoldiers = recruitList.size();
        if(currentNumberOfSoldiers < maxNumberOfSoldiers){
            recruitList.add(person);
            currentNumberOfSoldiers++;
        }else {
            System.out.println("Military unit is full!");
        }
    }
    //TODO: check for same soldier in military unit!

    public int getNumberOfVacantPlaces(){
        return maxNumberOfSoldiers - currentNumberOfSoldiers;
    }

    public List<Person>getListOfRecruits(){
        return recruitList;
    }

    public int getMaxNumberOfSoldiers() {
        return maxNumberOfSoldiers;
    }

    public int getCurrentNumberOfSoldiers() {
        return currentNumberOfSoldiers;
    }
}
