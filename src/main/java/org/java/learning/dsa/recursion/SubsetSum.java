package org.java.learning.dsa.recursion;


import java.util.ArrayList;
import java.util.Collections;

/**
 * GFG problem
 * Input: arr[] = [2, 3]
 * Output: [0, 2, 3, 5]
 * Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2.
 * When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
 */

public class SubsetSum {
    static int sum;
    public void recursion (int ind, int[] ar, ArrayList<Integer> res, int sum) {


        if (ind == ar.length) {
            res.add(sum);
            return;
        }

        recursion(ind+1, ar, res, sum+ar[ind]);
        recursion(ind+1, ar, res, sum);

    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here

        ArrayList<Integer> res = new ArrayList<>();

        sum = 0;
        recursion(0, arr, res, sum);

        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
