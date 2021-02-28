package by.home.service;

import by.home.input.HomeFileReader;
import by.home.output.HomeFileWriter;

import java.io.*;
import java.util.*;

public class Util {

    public static void writeInputStringInFile(String outputFile) throws IOException {
        System.out.println("Input string: ");
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

    public static String readStringFromConsole(String param) throws IOException {
        System.out.printf("Input %s\n", param);
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            return bf.readLine();
        }
    }

    public static void addAppropriateTextInFile(List<String> sentences, String filePath) throws IOException {
        int countWords;
        boolean isPalindromePresent;
        HomeFileWriter writer = new HomeFileWriter(filePath);
        for (String sentence : sentences) {
            countWords = TextFormatter.countWordsInLine(sentence);
            isPalindromePresent = TextFormatter.isPalindromeInSentence(sentence);
            if (countWords >= 3 && countWords <= 5 || isPalindromePresent) {
                writer.append(sentence);
            }
        }
        System.out.println("File has been updated!");
    }

    public static void writePalindromesInFile(String readFileDir, String fileToWriteDir) throws IOException {
        HomeFileReader reader = new HomeFileReader(readFileDir);
        String fileInfo = reader.readLine();
        String[] mass = fileInfo.split("[\\n\\r]+");
        HomeFileWriter homeFileWriter = new HomeFileWriter(fileToWriteDir);
        for (String word : mass) {
            if (TextFormatter.isPalindromeInSentence(word)) {
                homeFileWriter.append(word);
            }
        }
        System.out.println("File was created!");
    }

}
