package by.home.service;

import by.home.model.CashDesk;

import java.util.List;

public class CashDeskUtil {

    public static CashDesk getCashDeskWithMinQueue(List<CashDesk> cashDesks) {
        cashDesks.sort(new QueueComparator());
        return cashDesks.get(0);
    }

}
