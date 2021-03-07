package by.home.model.enums;

public enum MenuElement {

    PRINT_ALL_ITEMS(1),
    ADD_ITEM(2),
    DELETE_ITEM(3),
    EDIT_ITEM(4),
    ADD_QUANTITY(5),
    EXIT(0);

    private final int number;

    MenuElement(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "MenuElements{" +
                "number='" + number + '\'' +
                '}';
    }
}
