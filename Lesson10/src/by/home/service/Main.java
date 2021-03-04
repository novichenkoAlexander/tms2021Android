package by.home.service;

import by.home.model.CashDesk;
import by.home.model.Customer;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CashDesk cashDesk1 = new CashDesk(1);
        CashDesk cashDesk2 = new CashDesk(2);
        CashDesk cashDesk3 = new CashDesk(3);
        List<CashDesk> cashDesks = new LinkedList<>();
        cashDesks.add(cashDesk1);
        cashDesks.add(cashDesk2);
        cashDesks.add(cashDesk3);

        for (int i = 1; i <= 10; i++) {
            new Thread(new Customer(String.valueOf(i), cashDesks)).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
