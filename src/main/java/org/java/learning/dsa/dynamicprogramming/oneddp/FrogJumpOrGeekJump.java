package org.java.learning.dsa.dynamicprogramming.oneddp;

import java.util.Arrays;

/**
 * @Example:
 * Input:
 * n = 4
 * height = {10 20 30 10}
 * Output:
 * 20
 * Explanation:
 * Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
 * Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
 * so, total energy lost is 20 which is the minimum.
 */
public class FrogJumpOrGeekJump {
    static int[] t;
    public int fibonacci(int[] arr, int n) {
        if(n == 0) return 0;

        // if(t[n] != -1)
        //     return t[n];
        int right = Integer.MAX_VALUE;
        t[0] = 0;
        for(int i = 1; i < n; i++) {
            int left = t[i-1] + Math.abs(arr[i] - arr[i-1]);

            if(i>1) {
                right = t[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            t[i] = Math.min(left, right);
        }
        return t[n-1];
    }
    public int minimumEnergy(int[] arr, int n) {
        //code here
        t = new int[n];
        Arrays.fill(t, 0);
        return fibonacci(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30,10};
        FrogJumpOrGeekJump ob = new FrogJumpOrGeekJump();
        System.out.println(ob.minimumEnergy(arr, arr.length));
    }
}
