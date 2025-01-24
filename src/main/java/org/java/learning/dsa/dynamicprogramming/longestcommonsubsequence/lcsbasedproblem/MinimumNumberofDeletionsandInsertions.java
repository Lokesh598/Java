package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


/**
 * Given two strings str1 and str2. The task is to remove or insert
 * the minimum number of characters from/in str1 so as to transform it into str2.
 *
 * Input: str1 = "heap", str2 = "pea"
 * Output: 3
 */
public class MinimumNumberofDeletionsandInsertions {
    static int[][] tb;
    public static int lcs(int x, int y, String s1, String s2) {
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
                } else {
                    tb[i][j] = Math.max(tb[i][j-1], tb[i-1][j]);
                }
            }
        }
        return tb[x][y];
    }
    public static int minOperations(String s1, String s2)
    {
        // Your code goes here
        int m = s1.length();
        int n = s2.length();
        int lcs = lcs(m, n, s1, s2);
        int del = m-lcs;
        int in = n-lcs;
        return del+in;
    }

    public static void main(String[] args) {
        int res = minOperations("heap", "pea");
        System.out.println(res);
    }
}
