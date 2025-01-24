package org.java.learning.dsa.dynamicprogramming.oneddp;

public class NStairs {
    static int[] dp;
    static int fibonacci(int n) {
//        if (n==0 || n==1)
//            return n;
//        if(dp[n] != -1)
//            return dp[n];
//        else {
//            dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
//            return dp[n]% 1000000007;
//        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }
        return dp[n];
    }
    static int ways(int n) {
        return fibonacci(n+1);
    }

    public static void main(String[] args) {
        int n = 89;
        dp = new int[n+1];
        for (int i = 0; i<n+1; i++) {
            dp[i] = -1;
        }
        System.out.println(ways(84));
    }
}
