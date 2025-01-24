package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


/**
 * @Link: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
 *
 * @Problem: Given two strings. The task is to find the length of the longest common substring.
 *
 * @Example: Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
 * Output: 4
 * Explanation: The longest common substring
 * is "CDGH" which has length 4.
 */
public class LongestCommonSubstring {
    static int[][] tb;
    static int longestCommonSubstr(String s1, String s2, int x, int y){
        // code here
        int res = 0;
        tb = new int[x+1][y+1];
        for(int i = 0; i<x+1; i++) {
            for(int j = 0; j<y+1; j++) {
                if(i == 0 || y == 0)
                    tb[i][j] = 0;
            }
        }
        for(int i = 1; i<x+1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    tb[i][j] = 1 + tb[i-1][j-1];
                    res = Math.max(res, tb[i][j]);
                } else {
                    tb[i][j] = 0;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int res = longestCommonSubstr("ACDGHR", "ABCDGH", 6, 6);
        System.out.println(res);
    }
}
