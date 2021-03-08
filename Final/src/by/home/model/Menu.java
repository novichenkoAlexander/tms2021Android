package by.home.model;

import by.home.exceptions.EqualsItemIdException;
import by.home.exceptions.IncorrectInputException;
import by.home.exceptions.ItemNotFoundException;
import by.home.exceptions.StoreIsEmptyException;
import by.home.model.enums.MenuElement;
import by.home.model.enums.SortPrintedItems;
import by.home.service.ConsoleReader;
import by.home.service.ItemUtil;

import java.util.EnumSet;
import java.util.Map;

public class Menu {
    private final Store store;
    private final ConsoleReader reader;
    private Map<Item, Integer> itemsWithQuantity;

    public Menu(Store store) {
        this.store = store;
        reader = new ConsoleReader();
    }

    public boolean start() throws IncorrectInputException, StoreIsEmptyException, EqualsItemIdException, ItemNotFoundException {
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
    private boolean menuInit() throws IncorrectInputException, StoreIsEmptyException, EqualsItemIdException, ItemNotFoundException {
        boolean isExit = false;
        int menuItemNumber = reader.readIntNumber();
        if (menuItemNumber == 0) {                                         // 0 - Exit
            isExit = true;
        } else if (menuItemNumber >= 0 && menuItemNumber < 6) {
            switch (getMenuElementByNumber(menuItemNumber)) {
                case PRINT_ALL_ITEMS -> printAllItems();                        // 1
                case ADD_ITEM -> store.addItem(ItemUtil.createItem());          // 2
                case DELETE_ITEM -> deleteItemById();                           // 3
                case EDIT_ITEM -> editItemById();                               // 4
                case ADD_QUANTITY -> addQuantity();                             // 5
                case EXIT -> System.out.println("Exit");                        // 0
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
            System.out.println("Input item id to set quantity:");
            int itemId = reader.readIntNumber();
            System.out.println("Input quantity:");
            int quantity = reader.readIntNumber();
            for (Item item : itemsWithQuantity.keySet()) {
                if (itemId == item.getId()) {
                    itemsWithQuantity.put(item, quantity);
                    break;
                } else {
                    throw new ItemNotFoundException("No item with such id!");
                }
            }
        }
    }

    private SortPrintedItems getItemSortParam(int number, EnumSet<SortPrintedItems> param) throws IncorrectInputException {
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
            if (number == element.getValue()) {
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
                "0 - exit");
    }

}

