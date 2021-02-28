package by.home.service;

import by.home.model.Item;

import java.util.Comparator;

public class Sort implements Comparator<Item> {
    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
