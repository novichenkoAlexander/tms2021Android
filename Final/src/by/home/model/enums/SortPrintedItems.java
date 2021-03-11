package by.home.model.enums;


import java.util.EnumSet;

public enum SortPrintedItems {
    BY_PRICE_CHEAP_FIRST(1), BY_PRICE_EXPENSIVE_FIRST(2),
    BY_ORDER_FIRST_NEW(1), BY_ORDER_FIRST_OLD(2);

    private final int number;

    public static EnumSet<SortPrintedItems> price = EnumSet.of(BY_PRICE_CHEAP_FIRST, BY_PRICE_EXPENSIVE_FIRST);
    public static EnumSet<SortPrintedItems> order = EnumSet.of(BY_ORDER_FIRST_NEW, BY_ORDER_FIRST_OLD);

    SortPrintedItems(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
