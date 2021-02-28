package by.home.model;

import by.home.exceptions.ItemIdMissMatchException;
import by.home.service.EditState;
import by.home.service.Sort;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private final LinkedList<Item> itemList;

    public Store() {
        itemList = new LinkedList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Item> getItemListByPrice() {
        LinkedList<Item> sortedItems = (LinkedList) itemList.clone();
        sortedItems.sort(new Sort());
        return sortedItems;
    }

    public void addItem(Item item) throws ItemIdMissMatchException {
        boolean added = false;
        if (itemList.isEmpty()) {
            itemList.add(0, item);
            added = true;
        } else {
            for (Item element : itemList) {
                if (item.getId() != element.getId()) {
                    itemList.add(0, item);
                    added = true;
                }
                break;
            }
        }
        printEditItemState(EditState.ADD, added, item.getName());
    }

    private void printEditItemState(EditState param, boolean state, String itemName) throws ItemIdMissMatchException {
        if (state) {
            switch (param) {
                case ADD -> System.out.printf("Item '%s' has been added to store\n", itemName);
                case EDIT -> System.out.printf("Item %s has been edited\n", itemName);
                case DELETE -> System.out.printf("Item with id = %s has been deleted\n", itemName);
            }
        } else {
            switch (param) {
                case ADD -> throw new ItemIdMissMatchException("Item with this id is already exists");
                case EDIT, DELETE -> throw new ItemIdMissMatchException("No item with this id");
            }
        }

    }

    public void deleteItem(int id) throws ItemIdMissMatchException {
        boolean deleted = false;
        for (Item item : itemList) {
            if (item.getId() == id) {
                itemList.remove(item);
                deleted = true;
                break;
            }
        }
        printEditItemState(EditState.DELETE, deleted, String.valueOf(id));
    }

    public void editItem(Item item) throws ItemIdMissMatchException {
        boolean edited = false;
        for (Item listItem : itemList) {
            if (listItem.getId() == item.getId()) {
                listItem.setName(item.getName());
                listItem.setType(item.getType());
                listItem.setPrice(item.getPrice());
                edited = true;
                break;
            }
        }
        printEditItemState(EditState.EDIT, edited, item.getName());
    }

}
