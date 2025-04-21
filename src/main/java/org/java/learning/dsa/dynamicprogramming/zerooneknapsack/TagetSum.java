package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

import java.util.Scanner;


/**
 * This is extended of Partition With given difference problem....
 *
 * @Example:
 * Input:
 * N = 5
 * A[] = {1, 1, 1, 1, 1}
 * target = 3
 * Output:
 * 5
 */
public class TagetSum {
    static int m = (int)(Math.pow(10,9)+7);
    static int[][] dp;
    public static int targetSum(int n, int arr[], int sumOfS1) {

        dp = new int[n+1][sumOfS1+1];

        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<sumOfS1+1; j++) {
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < sumOfS1+1; j++) {
                // dp[0][0] = 1;
                // dp[i][0] = 1;
                // dp[0][j] = 0;
                if (arr[i-1] <= j) {
                    dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j])%m;
                } else {
                    dp[i][j] = dp[i-1][j]%m;
                }
            }
        }
        return dp[n][sumOfS1]%m;
    }
    static int findTargetSumWays(int[] arr , int n, int target) {
        // code here
        int sumOfArr = 0;
        for (int i : arr) {
            sumOfArr += i%m;
        }

        if(sumOfArr - target < 0 || ((sumOfArr-target)%2) == 1) return 0;

        int sumOfS1 = (sumOfArr - target)/2;

        return targetSum(n, arr, sumOfS1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = findTargetSumWays(arr, n, target);
        System.out.println(res);
    }
}
