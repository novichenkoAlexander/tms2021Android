package by.home.output;

import java.io.IOException;

public interface Writer {
    void write(String text) throws IOException;
    void append(String text) throws IOException;
}
