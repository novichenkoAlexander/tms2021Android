package by.home.model;

import by.home.exceptions.EqualsItemIdException;
import by.home.exceptions.ItemNotFoundException;
import by.home.exceptions.StoreIsEmptyException;
import by.home.model.enums.OperationWithItem;
import by.home.service.ItemComparator;

import java.util.*;

public class Store {

    private LinkedHashMap<Item, Integer> items;

    public Store() {
        items = new LinkedHashMap<>();
    }

    public void setItems(LinkedHashMap<Item, Integer> items) {
        this.items = items;
    }

    public LinkedHashMap<Item, Integer> getItems() {     // first old
        return items;
    }

    public LinkedHashMap<Item, Integer> getItemsFirstNew() {
        List<Item> sortedItems = new ArrayList<>(items.keySet());
        Collections.reverse(sortedItems);
        return returnMapFromList(sortedItems);
    }

    public LinkedHashMap<Item, Integer> getItemsByPriceDown() {
        List<Item> sortedItems = new ArrayList<>(items.keySet());
        sortedItems.sort(new ItemComparator());
        return returnMapFromList(sortedItems);
    }

    public LinkedHashMap<Item, Integer> getItemsByPriceUp() {
        List<Item> sortedItems = new ArrayList<>(items.keySet());
        sortedItems.sort(Collections.reverseOrder(new ItemComparator()));
        return returnMapFromList(sortedItems);
    }

    public void addItem(Item item) throws ItemNotFoundException, EqualsItemIdException {
        boolean added = false;
        if (!items.containsKey(item)) {
            items.put(item, 1);
            added = true;
        }
        printItemState(OperationWithItem.ADD_ITEM, added, item.getName());
    }

    public void deleteItem(int id) throws ItemNotFoundException, EqualsItemIdException {
        boolean deleted = false;
        for (Item item : items.keySet()) {
            if (item.getId() == id) {
                items.remove(item);
                deleted = true;
                break;
            }
        }
        printItemState(OperationWithItem.DELETE_ITEM, deleted, String.valueOf(id));
    }

    public void editItem(Item item) throws EqualsItemIdException, ItemNotFoundException {
        boolean edited = false;
        if (items.containsKey(item)) {
            int i = items.get(item);
            items.remove(item);
            items.put(item, i);
            edited = true;
        }
        printItemState(OperationWithItem.EDIT_ITEM, edited, String.valueOf(item.getId()));
    }

    public boolean checkForNoProductsAvailable() throws StoreIsEmptyException {
        if (!items.keySet().isEmpty()) {
            return false;
        } else {
            throw new StoreIsEmptyException("The Store is Empty! Add some products");
        }
    }

    private LinkedHashMap<Item, Integer> returnMapFromList(List<Item> list) {
        LinkedHashMap<Item, Integer> newMap = new LinkedHashMap<>();
        for (Item item : list) {
            newMap.put(item, items.get(item));
        }
        return newMap;
    }

    private void printItemState(OperationWithItem param, boolean state, String itemName) throws ItemNotFoundException, EqualsItemIdException {
        if (state) {
            switch (param) {
                case ADD_ITEM -> System.out.printf("Item '%s' has been added to store\n", itemName);
                case EDIT_ITEM -> System.out.printf("Item with id = %s has been edited\n", itemName);
                case DELETE_ITEM -> System.out.printf("Item with id = %s has been deleted\n", itemName);
            }
        } else {
            switch (param) {
                case ADD_ITEM -> throw new EqualsItemIdException("Item with this id is already exists");
                case EDIT_ITEM, DELETE_ITEM -> throw new ItemNotFoundException("No item with this id");
            }
        }

    }
}
