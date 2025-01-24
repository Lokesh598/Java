package org.java.learning.dsa.dynamicprogramming.unboundedknapsack;

import java.io.IOException;
import java.util.Arrays;

public class CoinChangeMemoize {
    static int[][] dp;
    public static int countWays(int[] coins, int n, int sum) {
        if(dp[n][sum] != -1) return dp[n][sum];

        if(sum == 0) return 1;
        if(sum < 0) return 0;
        if(n == 0) return 0;
        dp[n][sum] = countWays(coins, n, sum - coins[n-1]) + countWays(coins, n-1, sum);
        return dp[n][sum];
    }
    public static void main(String[] args) throws IOException {
        int[] coins = new int[]{2, 5, 3};
        int sum = 5, n = 3;
        dp = new int[n+1][sum+1];
        for(int i = 0; i<=n; i++) {
            for (int j = 0; j<=sum; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(countWays(coins, 3, 5));
    }
}
