package by.home.service;

import by.home.exceptions.IncorrectInputException;
import by.home.model.Item;

import java.util.List;
import java.util.Map;

public class ItemUtil {


    public static void printList(List<Item> itemList) {
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    public static void printMap(Map<Item, Integer> map) {
        for (Item item : map.keySet()) {
            System.out.println(item + " qty: " + map.get(item));
        }
    }

    public static Item createItem() throws IncorrectInputException {
        ConsoleReader reader = new ConsoleReader();
        System.out.println("Id:");
        int id = reader.readIntNumber();
        System.out.println("Product name:");
        String name = reader.readString();
        System.out.println("Product type:");
        String type = reader.readString();
        System.out.println("Price, $");
        int price = reader.readIntNumber();
        return new Item(id, name, type, price);
    }

}
