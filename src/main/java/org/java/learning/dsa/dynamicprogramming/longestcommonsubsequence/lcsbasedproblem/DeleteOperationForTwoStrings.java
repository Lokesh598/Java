package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


/**
 * @Hint: Lcs variation (m+n - 2*lcs) leetcode problem, edit distance
 *
 * Find the minimum changes to convert one string to another
 *
 * @Problem: Given two strings word1 and word2, return the minimum number of steps required
 * to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to
 * make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class DeleteOperationForTwoStrings {
    static int[][] tb;
    public static int lcsUtils(String s1, String s2, int x, int y) {
        tb = new int[x+1][y+1];
        for(int i = 0; i<x+1; i++) {
            for(int j = 0; j<y+1; j++) {
                if(i == 0 || j == 0)
                    tb[i][j] = 0;
            }
        }
        for(int i = 1; i<x+1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    tb[i][j] = 1 + tb[i-1][j-1];
                } else {
                    tb[i][j] = Math.max(tb[i][j-1], tb[i-1][j]);
                }
            }
        }
        return tb[x][y];
    }

    public int minDistance(String s, String t) {
        int lcs = lcsUtils(s, t, s.length(), t.length());
        System.out.println(lcs);
        return (s.length() - lcs) + (t.length() - lcs);
    }
    public static void main(String[] args) {
        DeleteOperationForTwoStrings o = new DeleteOperationForTwoStrings();
        System.out.println(o.minDistance("sea", "eat"));
    }
}
