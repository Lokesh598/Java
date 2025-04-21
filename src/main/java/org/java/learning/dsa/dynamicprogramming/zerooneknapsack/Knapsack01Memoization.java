package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

public class Knapsack01Memoization {
    static int[][] dp;
    static int knapSack(int w, int[] wts, int[] val, int ind, int[][] dp)
    {
        // your code here
        if(ind == 0 || w == 0)
            return 0;
        if(dp[ind][w] != -1) {
            return dp[ind][w];
        }
        if(wts[ind-1] > w) {
            return dp[ind][w] = knapSack(w, wts, val, ind-1, dp);
        } else {
            return dp[ind][w] = Math.max(knapSack(w, wts, val, ind-1, dp), val[ind-1] + knapSack(w-wts[ind-1], wts, val, ind-1, dp));
        }

    }
    public static void main(String[] args) {
        int[] wts = {1, 3, 4, 5, 6};
        int[] val = {1, 4, 5, 7, 9};
        int w = 7;
        int n = wts.length;
        dp = new int[n+1][w+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapSack(w, wts, val, n, dp));
    }
}
