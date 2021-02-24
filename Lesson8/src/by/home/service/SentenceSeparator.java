package by.home.service;

import java.util.Arrays;
import java.util.List;

public class SentenceSeparator {
    private final String text;

    public SentenceSeparator(String text) {
        this.text = text;
    }

    public List<String> divideTextBySentences() {
        return Arrays.asList(text.split("[.!?]+"));
    }
}
