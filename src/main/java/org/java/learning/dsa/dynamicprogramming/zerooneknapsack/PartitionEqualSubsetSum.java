package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

import java.util.Scanner;

/**
 * Given an array arr[] of size N, check if it can be partitioned into two parts such that the
 * sum of elements in both parts is the same.
 *
 * example
 * Input: N = 4
 * arr = {1, 5, 11, 5}
 * Output: YES
 */
public class PartitionEqualSubsetSum {
    static boolean subsetSum(int n, int arr[], int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 1; i<dp.length; i++) {
            for (int j = 1; j<dp[0].length; j++) {

                dp[0][0] = true;
                dp[i][0] = true;
                dp[0][j] = false;

                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    static int equalPartition(int n, int arr[]) {
        int sum = 0;
        for (int i:arr) {
            sum = sum+i;
        }
//        System.out.println(sum);
        if(sum%2 == 0) {
            if(subsetSum(n, arr, sum/2))
                return 1;
            else
                return 0;
        }
        return 0;
    }
    public static void main(String[] args) {
        //arr
        //arr size
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = equalPartition(n, arr);
        if(res == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
