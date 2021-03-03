package by.home.model;

public class CashDesk {
    private int id;
    private int queueLength = 0;
    private boolean isFree = true;

    public CashDesk(int id) {
        this.id = id;
    }

    public int getQueueLength() {
        return queueLength;
    }

    public void incrementQueue() {
        this.queueLength++;
    }

    public int getId() {
        return id;
    }

    synchronized void serveTheCustomer() {
        while (queueLength < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queueLength--;
        notify();
    }

}