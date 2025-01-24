package org.java.learning.dsa.dynamicprogramming.unboundedknapsack;

import java.util.ArrayList;


/**
 * @Problem
 * Given a rod of length N inches and an array of prices, price[].
 * price[i] denotes the value of a piece of length i.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Note: Consider 1-based indexing.
 *
 * Input:
 * N = 8
 * Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
 * Output:
 * 22
 */
public class RodCutting {
    static int[][] dp;
    public static int unboundedKnapsack(int price[], ArrayList<Integer> length, int n) {
        dp = new int[n+1][n+1];
//        for (int i = 0; i<n+1; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j<n+1; j++) {
//            dp[0][j] = 0;
//        }
        for (int i = 1; i<n+1; i++) {
            for (int j = 1; j<n+1; j++) {
                if(length.get(i - 1) <= j) {
                    if(dp[i-1][j-length.get(i-1)] + price[i-1] > dp[i-1][j]) {
                        dp[i][j] = Math.max(price[i-1] + dp[i][j-length.get(i-1)], dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
    public static int cutRod(int[] price, int n) {
        //code here
        ArrayList<Integer> length = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            length.add(i+1);
        }
        return unboundedKnapsack(price, length, n);
    }
    public static void main(String[] args) {
        int n = 8;
        int[] price = new int[n];
        price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int res = cutRod(price, n);
        System.out.println(res);
    }
}
