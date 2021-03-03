package by.home.model;

import by.home.service.ProductGenerator;
import by.home.service.Util;

import java.util.HashSet;
import java.util.List;

public class Customer implements Runnable {

    private final String name;
    private final List<CashDesk> cashDesks;
    private final HashSet<String> products;

    public Customer(String name, List<CashDesk> desk) {
        this.name = name;
        this.cashDesks = desk;
        this.products = ProductGenerator.generateProdList();
    }

    public HashSet<String> getProducts() {
        return products;
    }

    @Override
    public void run() {
        System.out.println("Customer " + name + " is choosing the cashDesk...");

        // Choosing cashDesk whit minimum queue
        CashDesk shortestQueueCashDesk = Util.getCashDeskWithMinQueue(cashDesks);
        System.out.printf("Customer " + name + " selected CashDesk #%d\n", shortestQueueCashDesk.getId());
        shortestQueueCashDesk.incrementQueue();

        shortestQueueCashDesk.serveTheCustomer();
        System.out.println("Customer " + name + " bought:" + products);
    }
}

