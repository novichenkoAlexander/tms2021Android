package by.home.service;

import by.home.exceptions.ItemIdMissMatchException;
import by.home.model.Item;
import by.home.model.Store;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ItemIdMissMatchException {
        Item milk = new Item(1, "Savushkin", "dairy", 5);
        Item bred = new Item(2, "Mag", "grocery", 4);
        Item juice = new Item(3, "Rich", "drinks", 8);
        Item apple = new Item(4, "Mutsu", "fruits", 10);
        Item banana = new Item(5, "Banana", "fruits", 8);
        Item kivi = new Item(6, "Kivi", "fruits", 12);
        Item newKivi = new Item(6, "Kivi", "fruits", 14);

        //creating store
        Store groceryStore = new Store();
        groceryStore.addItem(milk);
        groceryStore.addItem(bred);
        groceryStore.addItem(juice);
        groceryStore.addItem(apple);
        groceryStore.addItem(banana);
        groceryStore.addItem(kivi);

        //print itemList sorted by price
        List<Item> storeList = groceryStore.getItemListByPrice();
        Util.printList(storeList);

        // deleting item
        groceryStore.deleteItem(2);

        //print itemList in the order of addition
        Util.printList(groceryStore.getItemList());

        //editing item and print list
        groceryStore.editItem(newKivi);
        Util.printList(groceryStore.getItemList());

    }
}
