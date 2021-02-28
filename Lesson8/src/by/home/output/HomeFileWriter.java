package by.home.output;

import java.io.FileWriter;
import java.io.IOException;

public class HomeFileWriter implements Writer {
    private final String filePath;

    public HomeFileWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String text) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text.trim());
        }
    }

    @Override
    public void append(String text) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(text.trim());
            writer.append("\n");
        }
    }
}
