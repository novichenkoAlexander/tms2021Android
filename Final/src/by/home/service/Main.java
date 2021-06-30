package by.home.service;

import by.home.model.Menu;
import by.home.model.Store;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu(new Store());
        boolean exit = false;
        while (!exit) {
            try {
                exit = menu.start();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}

