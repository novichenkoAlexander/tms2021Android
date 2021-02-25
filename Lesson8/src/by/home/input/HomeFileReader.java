package by.home.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
