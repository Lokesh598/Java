package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;

import java.util.ArrayList;
import java.util.List;

public class PrintAllCommonLongestSubstring {
    static int[][] tb;
    public static int lcs(String s1, String s2, int x, int y) {
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
    public static List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        List<String> res = new ArrayList<>();
        int len = lcs(s, t, s.length(), t.length());


        String str = "";
        for (int i = 0; i < len; i++) {
            str += "$";
        }

        int i = s.length(), j = t.length();
        int index = len - 1;

        StringBuilder ss = new StringBuilder(s);
        StringBuilder str1 = new StringBuilder(str);

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                str1.setCharAt(index, ss.charAt(i - 1));
                index--;
                i--;
                j--;
            } else {
                if (tb[i][j - 1] > tb[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
//        return str1;

        return res;
    }
    public static void main(String[] args) {
        List<String> res = all_longest_common_subsequences("ACDGHR", "ABCDGH");
        System.out.println(res);
    }
}
