package by.home.service;

import by.home.exceptions.IncorrectInputException;

public interface Reader {
    int readIntNumber() throws IncorrectInputException;
    String readString() throws IncorrectInputException;

}
