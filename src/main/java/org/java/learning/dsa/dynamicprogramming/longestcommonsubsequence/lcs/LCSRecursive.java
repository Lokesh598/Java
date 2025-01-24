package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcs;


/**
 * @Problem: Given two sequences, find the length of longest subsequence present in both of them.
 * Both the strings are of uppercase.
 *
 * @Example:
 * Input:
 * A = 6, B = 6
 * str1 = ABCDGH
 * str2 = AEDFHR
 * Output: 3
 * Explanation: LCS for input Sequences
 * “ABCDGH” and “AEDFHR” is “ADH” of
 * length 3.
 */
public class LCSRecursive {
    public static int lcs(int x, int y, String s1, String s2) {

        if(x == 0 || y == 0)
            return 0;
        if(s1.charAt(x-1) == s2.charAt(y-1)) {
            return 1 + lcs(x-1, y-1, s1, s2);
        } else {
            return Math.max(lcs(x, y-1, s1, s2), lcs(x-1, y, s1, s2));
        }
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        int res = lcs(s1.length(), s2.length(), s1, s2);
        System.out.println(res);
    }
}
