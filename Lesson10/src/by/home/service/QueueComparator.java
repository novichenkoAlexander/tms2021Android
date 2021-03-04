package by.home.service;

import by.home.model.CashDesk;

import java.util.Comparator;

public class QueueComparator implements Comparator<CashDesk> {

    @Override
    public int compare(CashDesk o1, CashDesk o2) {
        return o1.getQueueLength() - o2.getQueueLength();
    }
}
