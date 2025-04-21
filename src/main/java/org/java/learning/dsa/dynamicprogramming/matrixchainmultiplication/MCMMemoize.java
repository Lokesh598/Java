package org.java.learning.dsa.dynamicprogramming.matrixchainmultiplication;

import java.util.Arrays;


/**
 * @Example:
 * Input: N = 4
 * arr = {10, 30, 5, 60}
 * Output: 4500
 */
public class MCMMemoize {
    static int[][] t;
    static int solve(int arr[], int i, int j) {
        if(i >= j) return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int mn = Integer.MAX_VALUE;

        for(int k = i; k<j; k++) {

            int tmp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];

            if (mn > tmp) {
                mn = tmp;
            }
        }
        return t[i][j] = mn;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        t = new int[N+1][N+1];
        for(int[] i : t) {
            Arrays.fill(i, -1);
        }
        return solve(arr, 1, N-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 30, 5, 60};
        int ans = matrixMultiplication(arr.length, arr);
        System.out.println(ans);
    }
}
