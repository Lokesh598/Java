package org.java.learning.dsa.problemsolving;

/**
 * Given a array of numbers, combine adjacent elements and return minimum
 *
 * [12, 34, 21, 11, 43] = [1234, 2111, 43] = output is 43
 */
public class MinimumNumber {
    private static void  printMinimum(int[] arr) {

        int n = arr.length;
        if (n % 2 != 0) {
            n = n/2+1;
        } else {
            n = n/2;
        }
        String[] ans = new String[n];
        int j = 0;
        for (int i = 0; i < arr.length-1 && j < arr.length-1; i++) {
            ans[i] = String.valueOf(arr[j]) + String.valueOf(arr[j+1]);
            j = j + 2;
        }
        if ( arr.length % 2 != 0) {
            ans[n-1] = String.valueOf(arr[arr.length-1]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < ans.length; i++) {
            if (Integer.parseInt(ans[i]) < res) {
                res = Integer.parseInt(ans[i]);
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        printMinimum(new int[] {12, 34, 21, 11,3, 43, 11, 19});
    }
}
