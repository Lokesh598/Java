package org.java.learning.dsa.dynamicprogramming.oneddp;

public class FibonacciMemoized {
    static int[] dp;
    public static int fib(int n) {
        dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = -1;
        }
        if (n == 0 || n == 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
