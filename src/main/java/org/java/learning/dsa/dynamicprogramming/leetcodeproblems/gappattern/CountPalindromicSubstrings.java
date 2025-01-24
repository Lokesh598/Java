package org.java.learning.dsa.dynamicprogramming.leetcodeproblems.gappattern;

/**
 * @Leetcode: 647
 * Given a string s, return the number of palindromic substrings in it.
 *
 * @Example:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 */
public class CountPalindromicSubstrings {

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;
        for(int gap = 0; gap<s.length(); gap++) {
            for(int i = 0, j = gap; j<s.length(); i++, j++) {
                // diagonaly traverse
                if(gap == 0)
                    dp[i][j] = true;
                else if (gap == 1) {
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int res = countSubstrings("abc");
        System.out.println(res);
    }
}
