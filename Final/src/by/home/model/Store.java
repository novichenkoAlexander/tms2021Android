package by.home.model;

import by.home.exceptions.EqualsItemIdException;
import by.home.exceptions.ItemNotFoundException;
import by.home.exceptions.StoreIsEmptyException;
import by.home.model.enums.OperationWithItem;
import by.home.service.ItemComparator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Store {
    private final LinkedList<Item> itemList;

    public Store() {
        itemList = new LinkedList<>();
    }

    public List<Item> getItemsFirstNew() throws StoreIsEmptyException {
        if (!checkIsEmpty()) {
            return itemList;
        }
        return null;
    }

    public List<Item> getItemsFirstOld() throws StoreIsEmptyException {
        if (!checkIsEmpty()) {
            List<Item> sortedList = new LinkedList<>(itemList);
            sortedList.sort(Collections.reverseOrder());
            return sortedList;
        }
        return null;
    }

    public List<Item> getItemsByPriceDown() throws StoreIsEmptyException {
        if (!checkIsEmpty()) {
            LinkedList<Item> sortedItems = new LinkedList<>(itemList);
            sortedItems.sort(new ItemComparator());
            return sortedItems;
        }
        return null;
    }

    public List<Item> getItemsByPriceUp() throws StoreIsEmptyException {
        if (!checkIsEmpty()) {
            LinkedList<Item> sortedItems = new LinkedList<>(itemList);
            sortedItems.sort(Collections.reverseOrder(new ItemComparator()));
            return sortedItems;
        }
        return null;
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
        printItemState(OperationWithItem.EDIT_ITEM, edited, item.getName());
    }

    private boolean checkIsEmpty() throws StoreIsEmptyException {
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
                case EDIT_ITEM -> System.out.printf("Item %s has been edited\n", itemName);
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
