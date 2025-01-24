package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

/**
 * recursive solution for 01 knapsack
 */
public class KnapSack01Recursive {
    static int knapSack(int w, int[] wts, int[] val, int ind)
    {
        // your code here
        if(ind == 0 || w == 0)
            return 0;

        if(wts[ind-1] > w) {
            // exclude
            return knapSack(w, wts, val, ind-1);
        } else {
            // include or exclude
            return Math.max(knapSack(w, wts, val, ind-1), val[ind-1] + knapSack(w-wts[ind-1], wts, val, ind-1));
        }

    }
    public static void main(String[] args) {
        int[] wts = {1, 3, 4, 5, 6};
        int[] val = {1, 4, 5, 7, 9};
        int w = 7;
        int n = wts.length;

        System.out.println(knapSack(w, wts, val, n));
    }
}
