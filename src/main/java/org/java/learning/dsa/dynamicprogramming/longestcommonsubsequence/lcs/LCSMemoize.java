package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcs;

public class LCSMemoize {
    static int[][] tb;
    public static int lcs(int x, int y, String s1, String s2) {
        if(x == 0 || y == 0)
            return 0;

        if(tb[x][y] != -1) {
            return tb[x][y];
        }
        if(s1.charAt(x-1) == s2.charAt(y-1)) {
            return tb[x][y] = 1 + lcs(x-1, y-1, s1, s2);
        } else {
            return tb[x][y] = Math.max(lcs(x, y-1, s1, s2), lcs(x-1, y, s1, s2));
        }
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        tb = new int[1001][1001];
        for(int i = 0; i<1001; i++) {
            for (int j = 0; j<1001; j++) {
                tb[i][j] = -1;
            }
        }
        int res = lcs(s1.length(), s2.length(), s1, s2);
        System.out.println(res);
        for (int k = 0; k < s1.length()+1; k++) {
            for (int j = 0; j < s2.length()+1; j++) {
                System.out.print(tb[k][j] + " ");
            }
            System.out.println();
        }
    }
}
