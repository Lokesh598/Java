package org.java.learning.dsa.dynamicprogramming.unboundedknapsack;

import java.io.IOException;

public class CoinChangeRecursive {
    public static int countWays(int[] coins, int n, int sum) {
        if(sum == 0) return 1;
        if(sum < 0) return 0;
        if(n == 0) return 0;
        return countWays(coins, n, sum - coins[n-1]) + countWays(coins, n-1, sum);
    }

    public static void main(String[] args) throws IOException {
        int[] coins = new int[]{2, 5, 3};
        System.out.println(countWays(coins, 3, 5));
    }
}
