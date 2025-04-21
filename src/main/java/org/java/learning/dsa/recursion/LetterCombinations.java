package org.java.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits.length() == 0) return res;

        findLetterCombinations("", digits, res, map);

        return res;
    }

    private void findLetterCombinations(String combination, String digits, List<String> res, String[] mp) {
        if (digits.isEmpty()) {
            res.add(combination);
        } else {
            String chars = mp[digits.charAt(0) - '2'];
            for (char ch : chars.toCharArray()) {
                findLetterCombinations(combination + ch, digits.substring(1), res, mp);
            }
        }
    }
}
