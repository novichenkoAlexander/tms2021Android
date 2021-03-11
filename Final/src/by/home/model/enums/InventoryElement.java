package by.home.model.enums;

public enum InventoryElement {
    ITEMS_TYPE_COUNT(1),
    GENERAL_ITEMS_COUNT(2),
    AVERAGE_ITEMS_PRICE(3),
    AVERAGE_ITEMS_TYPE_PRICE(4);

    private final int value;

    InventoryElement(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
