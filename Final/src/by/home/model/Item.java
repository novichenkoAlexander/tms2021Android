package by.home.model;

import java.util.Objects;

public class Item {
    private final int id;
    private final String name;
    private final String type;
    private final int price;


    public Item(int id, String name, String type, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item:" +
                " id = " + id + ';' +
                " name = '" + name + "';" +
                " type = " + type + ';' +
                " price = " + price;
    }
}
