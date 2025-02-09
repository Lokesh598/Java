package org.java.learning.dsa.patterns.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * this will be same solution if it is an array
 */
public class StringPermutation {
    public static void main(String[] args) {
        String input = "abcd";
        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        System.out.println(result);
    }

    private static void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);         // Swap to fix one character
            permute(chars, index + 1, result); // Recur for the rest
            swap(chars, index, i);         // Backtrack (undo swap)
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
