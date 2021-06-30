package by.home.exceptions;

public class NoEnoughItemQuantityException extends Exception {

    public NoEnoughItemQuantityException(String message) {
        //super(message);
        System.out.println(message);
    }
}
