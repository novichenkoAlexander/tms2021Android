package by.home.service;

import by.home.exceptions.EqualsItemIdException;
import by.home.exceptions.IncorrectInputException;
import by.home.exceptions.ItemNotFoundException;
import by.home.model.Menu;
import by.home.model.Store;

public class Main {
    public static void main(String[] args) throws ItemNotFoundException, EqualsItemIdException {
//        Item milk = new Item(1, "Savushkin", "dairy", 5);
//        Item bred = new Item(2, "Mag", "grocery", 4);
//        Item juice = new Item(3, "Rich", "drinks", 8);
//        Item apple = new Item(4, "Mutsu", "fruits", 10);
//        Item banana = new Item(5, "Banana", "fruits", 8);
//        Item kivi = new Item(6, "Kivi", "fruits", 12);
//        Item newKivi = new Item(6, "Kivi", "fruits", 12);
//
//        //creating store
//        Store groceryStore = new Store();
//        groceryStore.addItem(milk);
//        groceryStore.addItem(bred);
//        groceryStore.addItem(juice);
//        groceryStore.addItem(apple);
//        groceryStore.addItem(banana);
//        groceryStore.addItem(kivi);
//
//
//        //print itemList sorted by price
//        List<Item> storeList = groceryStore.getItemListByPrice();
//        ItemUtil.printList(storeList);
//
//        // deleting item
//        groceryStore.deleteItem(2);
//
//        //print itemList in the order of addition
//        ItemUtil.printList(groceryStore.getItemList());
//
//        //editing item and print list
//        groceryStore.editItem(newKivi);
//        ItemUtil.printList(groceryStore.getItemList());


        Store groceryStore = new Store();
        Menu menu = new Menu(groceryStore);
        int i = 0;          //TODO: loop start()
        while (i < 3) {
            i++;
            try {
                menu.start();
            } catch (IncorrectInputException e) {
                e.printStackTrace();
            }
        }

    }
}
