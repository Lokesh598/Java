package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


/**
 * @Problem:
 * Given two strings X and Y of lengths m and n respectively,
 * find the length of the smallest string which has both, X and Y as its sub-sequences.
 * Note: X and Y can have both uppercase and lowercase letters.
 * @Example:
 * Input:
 * X = abcd, Y = xycd
 * Output: 6(abxycd)
 */
public class ShortestCommonSupersequence {
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

    public static int shortestCommonSupersequence(String x,String y,int m,int n)
    {
        //Your code here
        int lcs = lcs(m, n, x, y);
        return (m+n)-lcs;
    }

    public static void main(String[] args) {
        int res = shortestCommonSupersequence("abcd", "xycd", 4, 4);
        System.out.println(res);
    }
}
