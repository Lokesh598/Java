package org.java.learning;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCountTool extends ClassLoader {
    public static int countValidWords(String string) {
        // Define vowels for quick reference
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Split the string into words
        String[] words = string.split("\\s+");
        int validWordCount = 0;

        for (String word : words) {
            // Skip words that contain any special characters or numbers
//            if (!word.matches("[a-zA-Z]+")) {
//                continue;
//            }

            // Check if the word has at least 3 characters
            if (word.length() < 3) {
                continue;
            }

            // Check for at least one vowel and one consonant
            boolean hasVowel = false, hasConsonant = false;
            for (char c : word.toLowerCase().toCharArray()) {
                if (vowels.contains(c)) {
                    hasVowel = true;
                } else if (Character.isAlphabetic(c)) {
                    hasConsonant = true;
                }

                // If both are found, the word is valid
                if (hasVowel && hasConsonant) {
                    validWordCount++;
                    break;
                }
            }
        }

        return validWordCount;
    }

    public static void main(String[] args) {
        // Example input
        String input = "This is Form16 submis$ion date.";

        // Get the count of valid words
        int result = countValidWords(input);

        // Output the result
        System.out.println("Number of valid words: " + result);
    }
}