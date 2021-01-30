package com.home.service;

import com.home.model.Address;
import com.home.model.Person;

import java.util.Scanner;


public class ConsoleInput {
    public static void main(String[] args) {
        Person person = parseInputLine(readLine());
        person.info();
    }

    /**
     * Made only for one-in-line input
     *
     */
    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create person by this template: ");
        System.out.println("age, name, country, gender");
        String line = "";
        while (true) {
            if (scanner.hasNextLine()) {
                line = scanner.next();
                break;
            }

        }
        return line;
    }

    public static Person parseInputLine(String line) {
        String[] strings = line.split(",");
        int age = 0;
        String name = "";
        String country = "";
        String gender = "";
            for (int i = 0; i < strings.length; i++){
                switch (i){
                    case 0:
                        age = Integer.parseInt(strings[i]);
                    case 1:
                        name = strings[i];
                    case 2:
                        country = strings[i];
                    case 3:
                        gender = strings[i];
                        break;
                    default:
                        System.out.println("Alarm");
                }
            }
            return new Person(age,name,new Address(country),gender);
        }

    }


