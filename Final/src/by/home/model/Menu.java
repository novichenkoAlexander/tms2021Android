package by.home.model;

import by.home.exceptions.*;
import by.home.model.enums.InventoryElement;
import by.home.model.enums.MenuElement;
import by.home.model.enums.SortPrintedItems;
import by.home.service.ConsoleReader;
import by.home.service.ItemUtil;

import java.util.EnumSet;
import java.util.Objects;

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
     * @throws IncorrectInputException - when input number doesn't match menu item number
     * @throws StoreIsEmptyException   - when the store is empty
     * @throws EqualsItemIdException   - when trying to add item with same id
     * @throws ItemNotFoundException   - when trying to delete/edit item with absent id
     */
    private boolean menuInit() throws IncorrectInputException, StoreIsEmptyException, EqualsItemIdException, ItemNotFoundException, NoEnoughItemQuantityException {
        boolean isExit = false;
        int menuItemNumber = reader.readIntNumber();
        if (menuItemNumber == 0) {
            isExit = true;
        } else if (menuItemNumber >= 0 && menuItemNumber < MenuElement.values().length) {
            switch (Objects.requireNonNull(getMenuElementByNumber(menuItemNumber))) {
                case PRINT_ALL_ITEMS -> printAllItems();
                case ADD_ITEM -> {
                    System.out.println("---ADD ITEM---");
                    store.addItem(ItemUtil.createItem());
                }
                case DELETE_ITEM -> deleteItemById();
                case EDIT_ITEM -> editItemById();
                case ADD_QUANTITY -> addQuantity();
                case BUY_PRODUCT -> buyProduct();
                case INVENTORY -> workWithInventory();
                case EXIT -> System.out.println("Exit");
            }
        } else {
            throw new IncorrectInputException("Incorrect input number!");
        }
        return isExit;
    }

    /**
     * Prints all items in console depending on chosen sort parameter
     *
     * @throws IncorrectInputException - when user input wrong menu item number
     * @throws StoreIsEmptyException   - when there are no items in store
     */
    private void printAllItems() throws IncorrectInputException, StoreIsEmptyException {
        store.checkForAvailableProducts();
        System.out.println("1 - BY ORDER\n2 - BY PRICE");
        int itemSortNumber = reader.readIntNumber();
        EnumSet<SortPrintedItems> order = SortPrintedItems.order;
        EnumSet<SortPrintedItems> price = SortPrintedItems.price;
        if (itemSortNumber > 0 && itemSortNumber < 3) {
            switch (itemSortNumber) {
                case 1 -> {
                    System.out.println("-ORDER-");
                    System.out.println("1 - NEW FIRST\n" +
                            "2 - OLD FIRST");
                    switch (Objects.requireNonNull(getItemSortParam(reader.readIntNumber(), order))) {
                        case BY_ORDER_FIRST_NEW -> ItemUtil.printMap((store.getItemsFirstNew()));
                        case BY_ORDER_FIRST_OLD -> ItemUtil.printMap((store.getItems()));
                    }
                }
                case 2 -> {
                    System.out.println("-PRICE-");
                    System.out.println("1 - CHEAP FIRST\n" +
                            "2 - EXPENSIVE FIRST");
                    switch (Objects.requireNonNull(getItemSortParam(reader.readIntNumber(), price))) {
                        case BY_PRICE_CHEAP_FIRST -> ItemUtil.printMap(store.getItemsByPriceUp());
                        case BY_PRICE_EXPENSIVE_FIRST -> ItemUtil.printMap(store.getItemsByPriceDown());
                    }
                }
            }
        } else {
            throw new IncorrectInputException("Incorrect input number!");
        }

    }

    private void deleteItemById() throws StoreIsEmptyException, IncorrectInputException, EqualsItemIdException, ItemNotFoundException {
        if (store.checkForAvailableProducts()) {
            System.out.println("---DELETE ITEM---");
            System.out.println("Input item id:");
            store.deleteItem(reader.readIntNumber());
        }
    }

    private void editItemById() throws StoreIsEmptyException, IncorrectInputException, EqualsItemIdException, ItemNotFoundException {
        if (store.checkForAvailableProducts()) {
            System.out.println("---EDIT ITEM---");
            store.editItem(ItemUtil.createItem());
        }
    }

    private void addQuantity() throws ItemNotFoundException, IncorrectInputException, StoreIsEmptyException {
        if (store.checkForAvailableProducts()) {
            System.out.println("---ADD QUANTITY---");
            ItemUtil result = ItemUtil.returnIdAndQuantity();
            int itemId = result.getId();
            int quantity = result.getQuantity();
            boolean isPresent = true;
            for (Item item : store.getItems().keySet()) {
                if (itemId == item.getId()) {
                    store.getItems().put(item, quantity + 1);
                    System.out.println("Quantity of Item " + "'" + item.getName() + "'" + " increased by " + quantity);
                    isPresent = true;
                    break;
                } else {
                    isPresent = false;
                }
            }
            if (!isPresent) {
                throw new ItemNotFoundException("No item with such id!");
            }
        }

    }

    private void buyProduct() throws StoreIsEmptyException, IncorrectInputException, ItemNotFoundException, NoEnoughItemQuantityException, EqualsItemIdException {
        if (store.checkForAvailableProducts()) {
            System.out.println("---BUY ITEM---");
            ItemUtil result = ItemUtil.returnIdAndQuantity();
            int itemId = result.getId();
            int quantity = result.getQuantity();
            boolean found = false;
            for (Item item : store.getItems().keySet()) {
                if (itemId == item.getId()) {
                    checkForEnoughItems(item, itemId, quantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new ItemNotFoundException("No item with such id!");
            }
        }
    }

    private void checkForEnoughItems(Item item, int id, int quantity) throws EqualsItemIdException, ItemNotFoundException,
            NoEnoughItemQuantityException {
        int itemsAvailable = store.getItems().get(item);
        if (itemsAvailable >= quantity) {
            store.getItems().put(item, itemsAvailable - quantity);
            System.out.println("The customer bought " + item.getName() + " - " + quantity + " pcs");
            System.out.println("The cost is: " + item.getPrice() * quantity + " $");
            if (store.getItems().get(item) == 0) {
                store.deleteItem(id);
            }
        } else {
            throw new NoEnoughItemQuantityException("No enough quantity of this Item!");
        }
    }

    private void workWithInventory() throws IncorrectInputException, StoreIsEmptyException {
        if (store.checkForAvailableProducts()) {
            Inventory inventory = new Inventory(store);
            printInventoryMenuInfo();
            int number = reader.readIntNumber();
            if (number > 0 && number <= InventoryElement.values().length) {
                switch (Objects.requireNonNull(getInventoryElement(number))) {
                    case ITEMS_TYPE_COUNT -> System.out.println("Number of item types: " +
                            inventory.getItemTypeCounts() + "\n");
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
        System.out.println("---INVENTORY---\n");
        System.out.println("""
                1 - ITEM TYPES COUNT;
                2 - GENERAL ITEMS COUNT;
                3 - AVERAGE ITEMS PRICE;
                4 - AVERAGE ITEMS TYPES PRICE;""");
    }

    private InventoryElement getInventoryElement(int number) {
        for (InventoryElement element : InventoryElement.values()) {
            if (element.getValue() == number) {
                return InventoryElement.valueOf(element.name());
            }
        }
        return null;
    }

    /**
     * @param number - value of enum element
     * @param param  - name of EnumSet group
     * @return Enum element by input number
     * @throws IncorrectInputException - when input number doesn't match number
     */
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
        System.out.println("\nChoose the option: ");
        System.out.println("""
                1 - PRINT ALL ITEMS;
                2 - ADD NEW ITEM;
                3 - DELETE ITEM;
                4 - EDIT ITEM;
                5 - ADD QUANTITY;
                6 - BUY ITEM;
                7 - INVENTORY;
                0 - EXIT""");
    }

}

