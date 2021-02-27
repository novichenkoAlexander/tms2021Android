package by.home.input;

import java.io.IOException;

public interface Reader {
    String readAllFile() throws IOException;
    String readLine()throws IOException;
}
