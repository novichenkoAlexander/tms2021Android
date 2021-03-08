package by.home.model;

import by.home.exceptions.*;
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
        if (menuItemNumber == 0) {                                         // 0 - Exit
            isExit = true;
        } else if (menuItemNumber >= 0 && menuItemNumber < 7) {
            switch (getMenuElementByNumber(menuItemNumber)) {
                case PRINT_ALL_ITEMS -> printAllItems();                        // 1
                case ADD_ITEM -> store.addItem(ItemUtil.createItem());          // 2
                case DELETE_ITEM -> deleteItemById();                           // 3
                case EDIT_ITEM -> editItemById();                               // 4
                case ADD_QUANTITY -> addQuantity();                             // 5
                case BUY_PRODUCT -> buyProduct();                               // 6
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
            ItemUtil result = ItemUtil.returnIdAndQuantity();
            int itemId = result.getId();
            int quantity = result.getQuantity();
            for (Item item : store.getItems().keySet()) {
                if (itemId == item.getId()) {
                    store.getItems().put(item, quantity + 1);
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
            for (Item item : store.getItems().keySet()) {
                if (itemId == item.getId()) {
                    int itemsAvailable = store.getItems().get(item);
                    if (itemsAvailable >= quantity) {
                        store.getItems().put(item, itemsAvailable - quantity);
                        System.out.println("The customer bought " + item.getName() + " - " + quantity + " pcs");
                        System.out.println("The cost is: " + item.getPrice() * quantity + " $");
                        if (store.getItems().get(item) == 0) {
                            store.deleteItem(itemId);
                        }
                    } else {
                        throw new NoEnoughItemQuantityException("No enough quantity of this Item!");
                    }
                    break;
                } else {
                    throw new ItemNotFoundException("No item with such id!");
                }
            }
        }
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
                "6 - Buy item;\n" +
                "0 - exit");
    }

}

