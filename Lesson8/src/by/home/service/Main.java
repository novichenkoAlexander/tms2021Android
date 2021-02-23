package by.home.service;

import java.io.*;


public class Main {
    private static final String RESOURCE_DIR = "Lesson8/resources/";
    private static final String OUTPUT_FILE = RESOURCE_DIR + "tmp.txt";


    public static void main(String[] args) throws IOException {
        String inputString = ConsoleUtil.readString();
        StringBuilder builder = new StringBuilder(inputString);
        String reverseString = builder.reverse().toString();

        try (FileOutputStream fos = new FileOutputStream(OUTPUT_FILE)) {
            fos.write(reverseString.getBytes());
            System.out.println("File has been overwritten!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

