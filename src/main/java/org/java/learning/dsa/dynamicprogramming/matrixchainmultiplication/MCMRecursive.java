package org.java.learning.dsa.dynamicprogramming.matrixchainmultiplication;

public class MCMRecursive {
    static int solve(int arr[], int i, int j) {
        if(i >= j) return 0;
        int mn = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++) {
            int tmp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            if (mn > tmp) { mn = tmp;}
        }
        return mn;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        //1 base case
        return solve(arr, 1, N-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 30, 5, 60};
        int ans = matrixMultiplication(arr.length, arr);
        System.out.println(ans);
    }
}
