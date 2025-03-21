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
