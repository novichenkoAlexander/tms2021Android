package by.home.service;

import java.util.Scanner;

public class ConsoleUtil {
    private static Scanner scanner;

    public static String readString() {
        System.out.println("Input string: ");
        String string = "";
        while (true) {
            scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                string = scanner.nextLine();
                break;
            }
        }
        return string;
    }
}
