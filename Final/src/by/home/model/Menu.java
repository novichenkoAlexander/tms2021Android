package by.home.model;

import by.home.exceptions.IncorrectInputException;
import by.home.model.enums.MenuElement;
import by.home.service.ConsoleReader;

public class Menu {
    private final Store store;
    private final ConsoleReader reader;
    private MenuElement menuElement;

    public Menu(Store store) {
        this.store = store;
        reader = new ConsoleReader();
    }

    public void start() throws IncorrectInputException {

        while (true) {
            printMenuInfo();
            int number = reader.readIntNumber();
            if (number == 0) {
                break;
            }
            menuInit(number);

        }

    }

    private void menuInit(int menuNumber) {
        switch (getMenuElements(menuNumber)) {
            case PRINT_ALL_ITEMS -> System.out.println("Print all");//TODO: method to print all items and so on
            case ADD_ITEM -> System.out.println("Add");
            case DELETE_ITEM -> System.out.println("Delete");
            case EDIT_ITEM -> System.out.println("Edit");
            case EXIT -> System.out.println("Exit");
        }
    }

    private static MenuElement getMenuElements(int number) {
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

