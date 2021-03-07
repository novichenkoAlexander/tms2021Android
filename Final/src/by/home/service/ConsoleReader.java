package by.home.service;

import by.home.exceptions.IncorrectInputException;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public int readIntNumber() throws IncorrectInputException {
        int result = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result >= 0)
                    break;
            } else {
                throw new IncorrectInputException("Incorrect number!");
            }
        }
        return result;
    }
}
