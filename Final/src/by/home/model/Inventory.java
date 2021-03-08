package by.home.model;

import java.util.*;

public class Inventory {
    private int itemTypeCounts;
    private int totalItemsCount = 0;
    private final Store store;

    public Inventory(Store store) {
        this.store = store;
    }

    /**
     * @return number of types of items, stored in store
     */
    public int getItemTypeCounts() {
        List<String> types = new LinkedList<>();
        for (Item item : store.getItems().keySet()) {
            if (!types.contains(item.getType())) {
                types.add(item.getType());
                itemTypeCounts++;
            }
        }
        return itemTypeCounts;
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
        return price / getTotalItemsCount();
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
            double averageProductTypePrice = price / getNumberOfItemsOfSameType(newMap);
            System.out.println("Item Type: " + "'" + type + "'" + " Price: " + averageProductTypePrice + " $");
        }
    }

    /**
     * @param map - storage of elements of equal types
     * @return number of all elements of same type
     */
    private int getNumberOfItemsOfSameType(HashMap<Item, Integer> map) {
        int number = 0;
        for (Item item : map.keySet()) {
            number += map.get(item);
        }
        return number;
    }

    /**
     * This method returns all elements of all types
     *
     * @return Map of String keys of 'type' to Map<Item,Integer> </>
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
     * This method returns all element of equal type.
     *
     * @param type - type of Item
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
