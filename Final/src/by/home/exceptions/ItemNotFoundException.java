package by.home.exceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String message) {
        //super(message);
        System.out.println(message);
    }
}
