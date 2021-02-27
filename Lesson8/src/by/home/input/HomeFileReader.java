package by.home.input;

import java.io.*;

public class HomeFileReader implements Reader {
    private final String inputFilePath;
    private final FileReader reader;
    private StringBuilder builder;

    public HomeFileReader(String inputFilePath) throws FileNotFoundException {
        this.inputFilePath = inputFilePath;
        reader = new FileReader(inputFilePath);
    }

    @Override
    public String readAllFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String result = null;
            String string;
            builder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                result = builder.append(string).toString();
            }
            return result;
        }

    }

    @Override
    public String readLine() throws IOException {
        try (BufferedReader buffReader = new BufferedReader(reader)) {
            StringBuilder result = null;
            int c;
            builder = new StringBuilder();
            while ((c = buffReader.read()) != -1) {
                result = builder.append((char) c);
            }
            return result.toString();
        }
    }
}
