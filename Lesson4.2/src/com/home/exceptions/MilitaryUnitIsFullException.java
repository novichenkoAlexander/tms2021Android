package com.home.exceptions;

public class MilitaryUnitIsFullException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public MilitaryUnitIsFullException() {
    }

    public MilitaryUnitIsFullException(String message){
        super(message);
    }
}
