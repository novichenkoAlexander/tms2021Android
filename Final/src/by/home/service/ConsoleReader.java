package by.home.service;

import by.home.exceptions.IncorrectInputException;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    private Scanner scanner;

    @Override
    public int readIntNumber() throws IncorrectInputException {
        int result;
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
            if (result >= 0) {
                return result;
            }
        } else {
            throw new IncorrectInputException("Incorrect number!");
        }
        return result;
    }

    @Override
    public String readString() throws IncorrectInputException {
        scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            throw new IncorrectInputException("Incorrect input!");
        }
    }
}

