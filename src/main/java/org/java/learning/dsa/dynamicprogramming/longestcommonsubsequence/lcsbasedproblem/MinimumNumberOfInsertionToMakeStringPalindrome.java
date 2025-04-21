package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


/**
 * @Problem: Form a palindrome
 * This problem same as Minimum#ofdeletion.
 * Given a string, find the minimum number of characters to be inserted to convert
 * it to palindrome.
 * For Example:
 * ab: Number of insertions required is 1. bab or aba
 * aa: Number of insertions required is 0. aa
 * abcd: Number of insertions required is 3. dcbabcd
 */
public class MinimumNumberOfInsertionToMakeStringPalindrome {
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

    public static int lps(String s)
    {
        //code here
        StringBuilder t = new StringBuilder();
        t.append(s);
        t.reverse();
        return lcs(s.length(), t.length(), s, t);
    }
    static int countMinInsertion(String str)
    {
        // code here
        int lps = lps(str);
        return str.length() - lps;
    }

    public static void main(String[] args) {
        int res = countMinInsertion("aebcbda");
        System.out.println(res);
    }
}
