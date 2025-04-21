package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;

public class LongestPalindromicSubsequence {
    /**
     * LPS == LCS(s, reverse(s));
     */
    static int[][] tb;
        public static int lcs(int x, int y, String s1, StringBuilder s2) {
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

    public static int longestPalinSubseq(String s)
    {
        //code here
        StringBuilder t = new StringBuilder();
        t.append(s);
        t.reverse();
        return lcs(s.length(), t.length(), s, t);
    }

    public static void main(String[] args) {
        int res = longestPalinSubseq("bbabcbcab");
        System.out.println(res);
    }
}
