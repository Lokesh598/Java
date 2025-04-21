package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;


/**
 * @Hint: Lcs variation (m+n - 2*lcs)
 */
public class EditDistance {
    /**
     * tabulation solution
     */
    static int[][] tb;
    public static int lcsUtil(int x, int y, String s1, String s2) {
        tb = new int[x+1][y+1];
        for(int i = 0; i<x+1; i++) {
            tb[i][0]=i;
        }
        for(int j = 0; j<y+1; j++) {
            tb[0][j]=j;
        }
        for(int i = 1; i<x+1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    tb[i][j] = tb[i-1][j-1];
                } else {
                    tb[i][j] =1 + Math.min(tb[i-1][j], Math.min(tb[i][j-1],
                            tb[i-1][j-1]));
                }
            }
        }
        return tb[x][y];
    }

    public static int editDistance(String s, String t) {
        // Code here
        return lcsUtil(s.length(), t.length(), s, t);
    }

    /**
     * This Recursive Solution for edit distance solution
     * @param s
     * @param t
     * @return integer value
     */
    public static int editDistanceNaive(String s, String t, int m, int n) {
        if(m==0) return n;
        if(n==0) return m;
        if (s.charAt(m-1) == t.charAt(n-1))
            return editDistanceNaive(s, t, m-1, n-1);
        else
            return 1 + Math.min(editDistanceNaive(s, t, m, n-1),
                        Math.min(editDistanceNaive(s, t, m-1, n),
                            editDistanceNaive(s, t, m-1, n-1)));
    }
    public static void main(String[] args) {
        System.out.println(editDistanceNaive("saturday","sunday", 8, 6));
        System.out.println(editDistance("ecfbefdcfca","badfcbebbf"));
    }
}
