package by.home.service;

public class TextFormatter {

    private static final String WORDS_SPLIT_REGEX = "[,;:\s]+";

    public static int countWordsInLine(String string) {
        return string.trim().split(WORDS_SPLIT_REGEX).length;
    }

    public static boolean isPalindromeInSentence(String string) {
        String[] words = string.trim().split(WORDS_SPLIT_REGEX);
        boolean palindromeIsPresent = false;
        for (String word : words) {
            StringBuilder builder = new StringBuilder(word);
            if (word.equalsIgnoreCase(builder.reverse().toString())) {
                palindromeIsPresent = true;
                break;
            } else {
                palindromeIsPresent = false;
            }
        }
        return palindromeIsPresent;
    }
}
