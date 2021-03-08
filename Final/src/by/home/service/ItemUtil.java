package by.home.service;

import by.home.exceptions.IncorrectInputException;
import by.home.model.Item;

import java.util.Map;

public class ItemUtil {

    private final int id;
    private final int quantity;

    public ItemUtil(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public static ItemUtil returnIdAndQuantity() throws IncorrectInputException {
        ConsoleReader reader = new ConsoleReader();
        System.out.println("Input id:");
        int id = reader.readIntNumber();
        System.out.println("Input quantity: ");
        int quantity = reader.readIntNumber();
        return new ItemUtil(id, quantity);
    }

    public static void printMap(Map<Item, Integer> map) {
        for (Item item : map.keySet()) {
            System.out.println(item + ";" + " qty: " + map.get(item));
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
