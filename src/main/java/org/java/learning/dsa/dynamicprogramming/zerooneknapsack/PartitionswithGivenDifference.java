package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

import java.util.Scanner;


/**
 * @Problem: extended of Minimum Sum Partion
 *
 *
 * Input:
 * n = 4, d = 3
 * arr[] =  { 5, 2, 6, 4}
 * Output:1
 */
public class PartitionswithGivenDifference {

    int m = (int)(Math.pow(10,9)+7);
    static int[][] dp;
    public static int perfectSum(int n, int arr[], int sumOfS1) {

        dp = new int[n+1][sumOfS1+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sumOfS1 + 1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < sumOfS1+1; j++) {
//                dp[0][0] = 1;
//                dp[i][0] = 1;
//                dp[0][j] = 0;
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sumOfS1];
    }
    public static int countPartitions(int n, int diff, int arr[]){
        // Code here
        //find sum of array
        int sumOfArr = 0;
        for (int i : arr) {
            sumOfArr += i;
        }
        if(sumOfArr - diff < 0 || ((diff + sumOfArr)%2) == 1) return 0;
        int sumOfS1 = (diff + sumOfArr)/2;

        return perfectSum(n, arr, sumOfS1);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = countPartitions(n, d, arr);
        System.out.println(res);
    }
}
