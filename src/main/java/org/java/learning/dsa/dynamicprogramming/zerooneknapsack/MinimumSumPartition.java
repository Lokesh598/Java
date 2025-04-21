package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

/**
 * @ProblemStatement:
 * Given an array arr of size n containing non-negative integers, the task is to divide it into two sets S1 and S2 such
 * that the absolute difference between their sums is minimum and find the minimum difference.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Example:
 * Input: N = 4, arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSumPartition {
    static boolean[][] dp;
    public static void subsetSum(int n, int[] arr, int sum) {

        dp = new boolean[n+1][sum+1];
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < sum+1; j++) {

                dp[0][0] = true;
                dp[i][0] = true;
                dp[0][j] = false;

                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
    public static int minDifference(int n, int arr[]) {
        int range = 0;
        int mn = Integer.MAX_VALUE;
        for(int i : arr){
            range += i;
        }
        //range is sum of given array values
        subsetSum(n, arr, range);

        // store last row in the vector those are true
        ArrayList<Integer> vector = new ArrayList<>();

        for(int j = 0; j<=range/2; j++) {
                if(dp[n][j]) {
//                    vector.add(j);
//                    System.out.println(j);
                    // instead of vector we will directly calculate the min
                    int s2 = range - j;
                    mn = Math.min(mn, Math.abs(s2- j));
                }
        }


//        for (int i: vector) {
//            mn = Math.min(mn, range - 2*i);
//        }
//        System.out.println(mn);
        return mn;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = minDifference(n, arr);
        System.out.println(min);
    }
}
