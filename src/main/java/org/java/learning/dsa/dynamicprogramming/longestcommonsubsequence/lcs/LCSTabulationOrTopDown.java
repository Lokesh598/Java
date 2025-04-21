package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcs;

import java.util.Arrays;

public class LCSTabulationOrTopDown {
    static int[][] tb;
    public static int lcsTabulation(int x, int y, String s1, String s2) {
        tb = new int[x+1][y+1];
//        for(int i = 0; i<x+1; i++) {
//            for(int j = 0; j<y+1; j++) {
//                if(i == 0 || j == 0)
//                    tb[i][j] = 0;
//            }
//        }
        for (int i[]: tb) {
            Arrays.fill(i, 0);
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
    public static void main(String[] args) {
        String s1 = "AEDFHR";
        String s2 = "ABCDGH";

        int res = lcsTabulation(s1.length(), s2.length(), s1, s2);
        System.out.println(res);
        for (int k = 0; k < s1.length()+1; k++) {
            for (int j = 0; j < s2.length()+1; j++) {
                System.out.print(tb[k][j] + " ");
            }
            System.out.println();
        }
    }

    private String reverse(String s) {
        char[] ch = s.toCharArray();

        int l = 0, r = ch.length-1;
        while (l <= r) {
            char tmp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = tmp;
        }
        return Arrays.toString(ch);
    }
}
