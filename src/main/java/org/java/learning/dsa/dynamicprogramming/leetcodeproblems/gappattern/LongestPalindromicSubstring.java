package org.java.learning.dsa.dynamicprogramming.leetcodeproblems.gappattern;

/**
 * this problem is variation of count palindromic substrings
 *
 * same problem gfg but this solution not passed all test cases on gfg. cpp solution
 * worked perfectly.
 *
 * leetcode all cases passed
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int length = 0;

        int start = 0, end = 0;
        for(int gap = 0; gap<s.length(); gap++) {
            for(int i = 0, j = gap; j<s.length(); i++, j++) {
                // diagonally traverse
                if(gap == 0)
                    dp[i][j] = true;
                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (gap == 1) {
                        if(b)
                            dp[i][j] = true;
                        else
                            dp[i][j] = false;
                    } else {
                        if(b && dp[i+1][j-1])
                            dp[i][j] = true;
                        else
                            dp[i][j] = false;
                    }
                }
                if(dp[i][j]) {
//                    length = gap+1; // for max length palindromic string
                    if(j-i+1 > length) {
                        length = j-i+1;
                    }
                    start = i;
                    end = j;
                }

            }
        }
        System.out.println(length);
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println(longestPalindrome(s));
    }
}
