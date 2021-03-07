package by.home.model;

import by.home.exceptions.EqualsItemIdException;
import by.home.exceptions.ItemNotFoundException;
import by.home.exceptions.StoreIsEmptyException;
import by.home.model.enums.OperationWithItem;
import by.home.service.ItemComparator;

import java.util.*;

public class Store {
    private final LinkedList<Item> itemList;

    public Store() {
        itemList = new LinkedList<>();
    }

    public List<Item> getItems() {
        return itemList;
    }

    public List<Item> getItemsFirstOld() {
        List<Item> sortedList = new LinkedList<>(itemList);
        Collections.reverse(sortedList);
        return sortedList;
    }

    public List<Item> getItemsByPriceDown() {
        LinkedList<Item> sortedItems = new LinkedList<>(itemList);
        sortedItems.sort(new ItemComparator());
        return sortedItems;
    }


    public List<Item> getItemsByPriceUp() {
        LinkedList<Item> sortedItems = new LinkedList<>(itemList);
        sortedItems.sort(Collections.reverseOrder(new ItemComparator()));
        return sortedItems;
    }

    public void addItem(Item item) throws ItemNotFoundException, EqualsItemIdException {
        boolean added = false;
        if (!itemList.contains(item)) {
            itemList.add(0, item);
            added = true;
        }
        printItemState(OperationWithItem.ADD_ITEM, added, item.getName());
    }

    public void deleteItem(int id) throws ItemNotFoundException, EqualsItemIdException {
        boolean deleted = false;
        for (Item item : itemList) {
            if (item.getId() == id) {
                itemList.remove(item);
                deleted = true;
                break;
            }
        }
        printItemState(OperationWithItem.DELETE_ITEM, deleted, String.valueOf(id));
    }

    public void editItem(Item item) throws EqualsItemIdException, ItemNotFoundException {
        boolean edited = false;
        if (itemList.contains(item)) {
            itemList.remove(item);
            itemList.add(item);
            edited = true;
        }
        printItemState(OperationWithItem.EDIT_ITEM, edited, String.valueOf(item.getId()));
    }

    public boolean checkForNoProductsAvailable() throws StoreIsEmptyException {
        if (!itemList.isEmpty()) {
            return false;
        } else {
            throw new StoreIsEmptyException("The Store is Empty! Add some products");
        }
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
