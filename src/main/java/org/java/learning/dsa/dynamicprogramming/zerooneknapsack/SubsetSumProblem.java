package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

import java.util.Scanner;

/**
 * @Problem:
 * Given an array of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 *
 * @Example:
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 9
 * Output: 1
 * Explanation: Here there exists a subset with
 * sum = 9, 4+3+2 = 9.
 */
public class SubsetSumProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = 5;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++ ){
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();

        boolean[][] t = new boolean[n+1][sum+1];

        for(int i = 1; i<t.length; i++) {
            for(int j = 1; j<t[0].length; j++) {

                t[i][0] = true;
                t[0][0] = true;
                t[0][j] = false;
                if(arr[i-1] <= j) { //arr is wt array here
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else
                    t[i][j] = t[i-1][j];
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(t[n][sum]);
    }
}
