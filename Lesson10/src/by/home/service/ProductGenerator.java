package by.home.service;

import java.util.HashSet;
import java.util.Random;

public class ProductGenerator {

    private static final String[] products = {"Milk", "Bread", "Potatoes", "Onion", "Bananas", "Apples", "Tea", "Coffee"};

    public static HashSet<String> generateProdList() {
        Random random = new Random();
        HashSet<String> productSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            productSet.add(products[random.nextInt(products.length)]);
        }
        return productSet;
    }
}
