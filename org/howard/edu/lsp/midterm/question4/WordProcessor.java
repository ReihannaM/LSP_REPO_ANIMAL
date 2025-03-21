package org.howard.edu.lsp.midterm.question4;

import java.util.*;

public class WordProcessor {
    private String sentence;

    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    // Method to find all longest words in the sentence
    public List<String> findLongestWords() {
        // Return an empty list if the sentence is empty
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }
    // Split the sentence into words, handling multiple spaces
        String[] words = sentence.trim().split("\\s+");

        // Find the maximum length of the words
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
    // Collect all words with the maximum length
        List<String> longestWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
