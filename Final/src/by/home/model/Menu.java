package by.home.model;

import by.home.exceptions.*;
import by.home.model.enums.InventoryElement;
import by.home.model.enums.MenuElement;
import by.home.model.enums.SortPrintedItems;
import by.home.service.ConsoleReader;
import by.home.service.ItemUtil;

import java.util.EnumSet;

public class Menu {
    private final Store store;
    private final ConsoleReader reader;

    public Menu(Store store) {
        this.store = store;
        reader = new ConsoleReader();
    }

    public boolean start() throws IncorrectInputException, StoreIsEmptyException, EqualsItemIdException, ItemNotFoundException, NoEnoughItemQuantityException {
        boolean isExit = false;
        while (!isExit) {
            printMenuInfo();
            isExit = menuInit();

        }
        return true;
    }

    /**
     * @return isExit = true when user pick "Exit"
     * @throws IncorrectInputException
     * @throws StoreIsEmptyException
     * @throws EqualsItemIdException
     * @throws ItemNotFoundException
     */
    private boolean menuInit() throws IncorrectInputException, StoreIsEmptyException, EqualsItemIdException, ItemNotFoundException, NoEnoughItemQuantityException {
        boolean isExit = false;
        int menuItemNumber = reader.readIntNumber();
        if (menuItemNumber == 0) {
            isExit = true;
        } else if (menuItemNumber >= 0 && menuItemNumber < MenuElement.values().length) {
            switch (getMenuElementByNumber(menuItemNumber)) {
                case PRINT_ALL_ITEMS -> printAllItems();
                case ADD_ITEM -> {
                    System.out.println("---ADD ITEM---");
                    store.addItem(ItemUtil.createItem());
                }
                case DELETE_ITEM -> {
                    System.out.println("---DELETE ITEM---");
                    deleteItemById();
                }
                case EDIT_ITEM -> {
                    System.out.println("---EDIT ITEM---");
                    editItemById();
                }
                case ADD_QUANTITY -> {
                    System.out.println("---ADD QUANTITY---");
                    addQuantity();
                }
                case BUY_PRODUCT -> {
                    System.out.println("---BUY ITEM---");
                    buyProduct();
                }
                case INVENTORY -> workWithInventory();
                case EXIT -> System.out.println("Exit");
            }
        } else {
            throw new IncorrectInputException("Incorrect input number!");
        }
        return isExit;
    }

    /**
     * Prints all items in console depending on chosen parameter
     *
     * @throws IncorrectInputException
     * @throws StoreIsEmptyException
     */
    private void printAllItems() throws IncorrectInputException, StoreIsEmptyException {
        if (!store.checkForNoProductsAvailable()) {
            System.out.println("1 - BY ORDER\n2 - BY PRICE");
            int itemSortNumber = reader.readIntNumber();
            EnumSet<SortPrintedItems> order = SortPrintedItems.order;
            EnumSet<SortPrintedItems> price = SortPrintedItems.price;
            if (itemSortNumber > 0 && itemSortNumber < 3) {
                switch (itemSortNumber) {
                    case 1 -> {
                        System.out.println("ORDER");
                        System.out.println("1 - New first\n" +
                                "2 - Old first");
                        switch (getItemSortParam(reader.readIntNumber(), order)) {
                            case BY_ORDER_FIRST_NEW -> ItemUtil.printMap((store.getItemsFirstNew()));
                            case BY_ORDER_FIRST_OLD -> ItemUtil.printMap((store.getItems()));
                        }
                    }
                    case 2 -> {
                        System.out.println("PRICE");
                        System.out.println("1 - Cheap first\n" +
                                "2 - Expensive first");
                        switch (getItemSortParam(reader.readIntNumber(), price)) {
                            case BY_PRICE_CHEAP_FIRST -> ItemUtil.printMap(store.getItemsByPriceUp());
                            case BY_PRICE_EXPENSIVE_FIRST -> ItemUtil.printMap(store.getItemsByPriceDown());
                        }
                    }
                }
            } else {
                throw new IncorrectInputException("Incorrect input number!");
            }
        } else {
            throw new StoreIsEmptyException("The Store is Empty! Add some products");
        }
    }

    private void deleteItemById() throws StoreIsEmptyException, IncorrectInputException, EqualsItemIdException, ItemNotFoundException {
        if (!store.checkForNoProductsAvailable()) {
            System.out.println("Input item id:");
            store.deleteItem(reader.readIntNumber());
        }
    }

    private void editItemById() throws StoreIsEmptyException, IncorrectInputException, EqualsItemIdException, ItemNotFoundException {
        if (!store.checkForNoProductsAvailable()) {
            store.editItem(ItemUtil.createItem());
        }
    }

    private void addQuantity() throws ItemNotFoundException, IncorrectInputException, StoreIsEmptyException {
        if (!store.checkForNoProductsAvailable()) {
            ItemUtil result = ItemUtil.returnIdAndQuantity();
            int itemId = result.getId();
            int quantity = result.getQuantity();
            for (Item item : store.getItems().keySet()) {
                if (itemId == item.getId()) {
                    store.getItems().put(item, quantity + 1);
                    System.out.println("Quantity of Item " + "'" + item.getName() + "'" + " increased by " + quantity);
                    break;
                } else {
                    throw new ItemNotFoundException("No item with such id!");
                }
            }
        }
    }

    private void buyProduct() throws StoreIsEmptyException, IncorrectInputException, ItemNotFoundException, NoEnoughItemQuantityException, EqualsItemIdException {
        if (!store.checkForNoProductsAvailable()) {
            ItemUtil result = ItemUtil.returnIdAndQuantity();
            int itemId = result.getId();
            int quantity = result.getQuantity();
            boolean found = false;
            for (Item item : store.getItems().keySet()) {
                if (itemId == item.getId()) {
                    isItemsEnough(item, itemId, quantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new ItemNotFoundException("No item with such id!");
            }
        }
    }

    private boolean isItemsEnough(Item item, int id, int quantity) throws EqualsItemIdException, ItemNotFoundException,
            NoEnoughItemQuantityException {
        boolean isEnough = true;
        int itemsAvailable = store.getItems().get(item);
        if (itemsAvailable >= quantity) {
            store.getItems().put(item, itemsAvailable - quantity);
            System.out.println("The customer bought " + item.getName() + " - " + quantity + " pcs");
            System.out.println("The cost is: " + item.getPrice() * quantity + " $");
            if (store.getItems().get(item) == 0) {
                store.deleteItem(id);
                isEnough = false;
            }
        } else {
            throw new NoEnoughItemQuantityException("No enough quantity of this Item!");
        }
        return isEnough;
    }

    private void workWithInventory() throws IncorrectInputException, StoreIsEmptyException {
        if (!store.checkForNoProductsAvailable()) {
            Inventory inventory = new Inventory(store);
            printInventoryMenuInfo();
            int number = reader.readIntNumber();
            if (number > 0 && number <= InventoryElement.values().length) {
                switch (getInventoryElement(number)) {
                    case ITEMS_TYPE_COUNT -> System.out.println("Number of item types: " +
                            inventory.getItemTypeCount() + "\n");
                    case GENERAL_ITEMS_COUNT -> System.out.println("General number of items in Store: " +
                            inventory.getTotalItemsCount() + "\n");
                    case AVERAGE_ITEMS_PRICE -> System.out.println("Average price of all items: " +
                            String.format("%.2f", inventory.getAverageProductsPrice()) + " $\n");
                    case AVERAGE_ITEMS_TYPE_PRICE -> inventory.printAverageProductTypePrice();
                }
            } else {
                throw new IncorrectInputException("Incorrect input number!");
            }
        }

    }

    private void printInventoryMenuInfo() {
        System.out.println("---INVENTORY---");
        System.out.println("1 - Item types count;\n" +
                "2 - General items count;\n" +
                "3 - Average items price;\n" +
                "4 - Average item types price;");
    }

    private InventoryElement getInventoryElement(int number) {
        for (InventoryElement element : InventoryElement.values()) {
            if (element.getValue() == number) {
                return InventoryElement.valueOf(element.name());
            }
        }
        return null;
    }

    private SortPrintedItems getItemSortParam(int number, EnumSet<SortPrintedItems> param) throws
            IncorrectInputException {
        if (number > 0 && number < 3) {
            for (SortPrintedItems m : param) {
                if (m.getNumber() == number) {
                    return SortPrintedItems.valueOf(m.name());
                }
            }
        } else {
            throw new IncorrectInputException("Incorrect input!");
        }
        return null;
    }

    private MenuElement getMenuElementByNumber(int number) {
        for (MenuElement element : MenuElement.values()) {
            if (element.getValue() == number) {
                return MenuElement.valueOf(element.name());
            }
        }
        return null;
    }

    private void printMenuInfo() {
        System.out.println("Choose the option: ");
        System.out.println("1 - Print all items;\n" +
                "2 - Add new item;\n" +
                "3 - Delete item;\n" +
                "4 - Edit item;\n" +
                "5 - Add quantity;\n" +
                "6 - Buy item;\n" +
                "7 - Inventory\n" +
                "0 - exit");
    }

}

