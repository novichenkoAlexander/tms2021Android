package by.home.service;

import by.home.model.Item;

import java.util.List;

public class ItemUtil {
    public static void printList(List<Item> itemList) {
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }
}
