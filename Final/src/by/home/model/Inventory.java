package by.home.model;

import java.util.*;

public class Inventory {
    private int itemTypeCount;
    private int totalItemsCount = 0;
    private double averageProductsPrice = 0;
    private double averageProductTypePrice;
    private final Store store;

    public Inventory(Store store) {
        this.store = store;
    }

    public int getItemTypeCount() {
        List<String> types = new LinkedList<>();
        for (Item item : store.getItems().keySet()) {
            if (!types.contains(item.getType())) {
                types.add(item.getType());
                itemTypeCount++;
            }
        }
        return itemTypeCount;
    }

    public int getTotalItemsCount() {
        List<Integer> list = new LinkedList<>(store.getItems().values());
        for (Integer integer : list) {
            totalItemsCount += integer.byteValue();
        }
        return totalItemsCount;
    }

    public double getAverageProductsPrice() {
        double price = 0;
        for (Item item : store.getItems().keySet()) {
            price += item.getPrice() * store.getItems().get(item);
        }
        averageProductsPrice = price / getTotalItemsCount();
        return averageProductsPrice;
    }

    public void printAverageProductTypePrice() {
        System.out.println("Average item types price:");
        HashMap<String, HashMap<Item, Integer>> map = getItemsTypeToCount();
        Set<String> itemTypes = map.keySet();
        for (String type : itemTypes) {
            double price = 0;
            HashMap<Item, Integer> newMap = map.get(type);
            for (Item item : newMap.keySet()) {
                price += item.getPrice() * newMap.get(item);        // sum of all items of same type
            }
            averageProductTypePrice = price / getNumberOfItemsOfSameType(newMap);
            System.out.println("Item Type: " + "'" + type + "'" + " Price: " + averageProductTypePrice + " $");
        }
    }

    private int getNumberOfItemsOfSameType(HashMap<Item, Integer> map) {
        int number = 0;
        for (Item item : map.keySet()) {
            number += map.get(item);
        }
        return number;
    }

    /**
     * @return Map of String keys of 'type' to Map<Item,Integer></>
     */
    private HashMap<String, HashMap<Item, Integer>> getItemsTypeToCount() {
        HashMap<String, HashMap<Item, Integer>> itemsTypeToCount = new HashMap<>();
        Set<Item> itemSet = store.getItems().keySet();
        for (Item item : itemSet) {
            String type = item.getType();
            if (!itemsTypeToCount.containsKey(type)) {
                itemsTypeToCount.putIfAbsent(item.getType(), getItemsByType(type));
            }
        }
        return itemsTypeToCount;
    }

    /**
     * @param type
     * @return Map of Item to Counts depending on type.
     */
    private HashMap<Item, Integer> getItemsByType(String type) {
        HashMap<Item, Integer> itemToCount = new HashMap<>();
        for (Item item : store.getItems().keySet()) {
            if (item.getType().equals(type)) {
                itemToCount.put(item, store.getItems().get(item));
            }
        }
        return itemToCount;
    }
}
