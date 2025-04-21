package org.java.learning.dsa.dynamicprogramming.matrixchainmultiplication;

import java.util.Arrays;

/**
 * @Example:
 * Input: str = "ababbbabbababa"
 * Output: 3
 * Explaination: After 3 partitioning substrings
 * are "a", "babbbab", "b", "ababa".
 */
public class PalindromicPartitioning {
    static int[][] dp;
    static boolean isPalindrome(String s, int i, int j) {
        if(i >= j) return true;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    static int solve(String s, int i, int j) {
        if(i>=j) return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(isPalindrome(s, i, j) == true)
            return 0;

        int mn = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int tmp = solve(s, i, k) + solve(s, k+1, j) + 1;
            if (mn > tmp)
                mn = tmp;
        }
        return dp[i][j] = mn;
    }
    static int palindromicPartition(String str)
    {
        // code here
        dp = new int[1001][1001];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return solve(str, 0, str.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(palindromicPartition("ababbbabbababa"));
    }
}
