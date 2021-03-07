package by.home.model;

import by.home.exceptions.IncorrectInputException;
import by.home.exceptions.StoreIsEmptyException;
import by.home.model.enums.MenuElement;
import by.home.model.enums.SortPrintedItems;
import by.home.service.ConsoleReader;
import by.home.service.ItemUtil;

import java.util.EnumSet;

public class Menu {
    private final Store store;
    private final ConsoleReader reader;
    private MenuElement menuElement;

    public Menu(Store store) {
        this.store = store;
        reader = new ConsoleReader();
    }

    public boolean start() throws IncorrectInputException, StoreIsEmptyException {
        boolean isExit = false;
        while (!isExit) {
            printMenuInfo();
            isExit = menuInit();

        }
        return true;
    }

    private boolean menuInit() throws IncorrectInputException, StoreIsEmptyException {
        boolean isExit = false;
        int menuItemNumber = reader.readIntNumber();
        if (menuItemNumber == 0) {      // 0 - Exit
            isExit = true;
        } else if (menuItemNumber >= 0 && menuItemNumber < 5) {
            switch (getMenuElementByNumber(menuItemNumber)) {
                case PRINT_ALL_ITEMS -> printAllItems();            // 1
                case ADD_ITEM -> System.out.println("Add");         // 2
                case DELETE_ITEM -> System.out.println("Delete");   // 3
                case EDIT_ITEM -> System.out.println("Edit");       // 4
                case EXIT -> System.out.println("Exit");            // 0
            }
        } else {
            throw new IncorrectInputException("Incorrect input number!");
        }
        return isExit;
    }

    private void printAllItems() throws IncorrectInputException, StoreIsEmptyException {
        System.out.println("1 - BY ORDER\n" +
                "2 - BY PRICE");
        int itemSortNumber = reader.readIntNumber();
        EnumSet<SortPrintedItems> orderParam = SortPrintedItems.order;
        EnumSet<SortPrintedItems> priceParam = SortPrintedItems.price;
        if (itemSortNumber > 0 && itemSortNumber < 3) {
            switch (itemSortNumber) {
                case 1 -> {
                    System.out.println("ORDER");
                    System.out.println("1 - New first\n" +
                            "2 - Old first");
                    switch (getItemSortParam(reader.readIntNumber(), orderParam)) {
                        case BY_ORDER_FIRST_NEW -> ItemUtil.printList(store.getItemsFirstNew());
                        case BY_ORDER_FIRST_OLD -> ItemUtil.printList(store.getItemsFirstOld());
                    }
                }
                case 2 -> {
                    System.out.println("PRICE");
                    System.out.println("1 - Cheap first\n" +
                            "2 - Expensive first");
                    switch (getItemSortParam(reader.readIntNumber(), priceParam)) {
                        case BY_PRICE_CHEAP_FIRST -> ItemUtil.printList(store.getItemsByPriceUp());
                        case BY_PRICE_EXPENSIVE_FIRST -> ItemUtil.printList(store.getItemsByPriceDown());
                    }
                }
            }
        } else {
            throw new IncorrectInputException("Incorrect input number!");
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
                "0 - exit");
    }

}

