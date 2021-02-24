package by.home.service;

import by.home.input.HomeFileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {
    private static final String RESOURCE_DIR = "Lesson8/resources/";
    private static final String NEW_TEXT_FILE = RESOURCE_DIR + "newText.txt";
    private static final String OUTPUT_FILE = RESOURCE_DIR + "output.txt";

    static {
        new File(NEW_TEXT_FILE).delete();
        new File(OUTPUT_FILE).delete();
    }

    public static void main(String[] args) throws IOException {


        /**
         * Writing reversed string in file output.txt
         */
//        Util.writeInputStringInFile(OUTPUT_FILE);

        /**
         * Task № 2: Read from text.txt. Write in newText.txt sentences that contain from 3 to 5 words.
         * If there is palindrome in sentence - write this sentence in new file no matter how many words in it.
         */
        String filePath = RESOURCE_DIR + Util.readStringFromConsole("File name");
        System.out.println(filePath);

        //Reading file
        HomeFileReader reader = new HomeFileReader(filePath);
        String textFromFile = reader.readAllFile();
        System.out.println(textFromFile);

        //Divide text by sentences
        SentenceSeparator separator = new SentenceSeparator(textFromFile);
        List<String> sentences = separator.divideTextBySentences();
        System.out.println(sentences.size());

        /**
         * Writing appropriate sentences in file newText.txt
         */
        Util.addAppropriateTextInFile(sentences, NEW_TEXT_FILE);

    }
}

