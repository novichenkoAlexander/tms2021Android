package by.home.service;

import java.io.*;
import java.util.Scanner;

public class ConsoleUtil {
    private static Scanner scanner;

    public static void writeInputStringInFile(String outputFile) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String inputString = bf.readLine();
            bw.write(reverseString(inputString));
            bw.flush();
            System.out.println("File has been overwritten!");
        }
    }

    private static String reverseString(String input) {
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }

}
