package org.java.learning.dsa.dynamicprogramming.oneddp;

import java.util.Arrays;

public class Fibonacci {
    static int[] dp;
    static int fibonacci(int n) {
        /*
        if(n<2) return n;
        if(dp[n] != 0)
            return dp[n];
        else {
            dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return dp[n];
        }*/
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        dp = new int[1001];
//        for(int i = 0; i< 1001; i++) {
//            dp[i] = 0;
//        }
        System.out.println(fibonacci(5));
    }
}
