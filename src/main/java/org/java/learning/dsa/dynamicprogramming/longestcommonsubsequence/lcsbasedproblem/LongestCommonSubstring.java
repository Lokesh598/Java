package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


import org.hibernate.cache.spi.support.SimpleTimestamper;

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

    static class LongestCommonSubstringRecursive {


//        static int count = 0;
        static int lcs(String s1, String s2, int m, int n, int count) {


            if (m == 0 || n == 0) return 0;

            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                count=lcs(s1, s2, m-1, n-1, count+1);
            }

            return Math.max(count, Math.max(lcs(s1, s2, m-1, n, count), lcs(s1, s2, m, n-1, count)));

        }
        static int[][] dp;
        static int lcsMemo(String s1, String s2, int m, int n) {
            int count = 0;
            if (m == 0 || n == 0) return count;

            tb = new int[m+1][n+1];
            for(int i = 0; i<m+1; i++) {
                for(int j = 0; j<n+1; j++) {
//                    if(i == 0 || n == 0)
                        tb[i][j] = -1;
                }
            }

            if (tb[m][n] != -1) {
                return tb[m][n];
            }

            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                count = lcs(s1, s2, m-1, n-1, count+1);
            }
            return dp[m][n] = Math.max(count, Math.max(lcs(s1, s2, m-1, n, count), lcs(s1, s2, m, n-1, count)));
        }

        public static void main(String[] args) {
            int res = lcs("abcdeac", "abcfcea", 7, 7, 0);
            System.out.println(res);
        }

    }
    public static void main(String[] args) {
        int res = longestCommonSubstr("ACDGHR", "ABCDGH", 6, 6);
        System.out.println(res);
    }
}
