package org.java.learning.dsa.problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SumOfKSmallestElementsInSubarrays {
    public static List<Integer> sumOfSmallestElementInSubarray(int[] arrs, int M, int k) {
        TreeSet<Integer> window = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < M; i++) {
            window.add(arrs[i]);
        }
        // Sum up the smallest K elements of the first window
        int smallestCount = 0;
        for (int x: window) {
            if (smallestCount == k) break;
            sum += x;
            smallestCount++;
        }
        result.add(sum);
        for (int i = M; i < arrs.length; i++) {
            //remove first element from window and add at last
            window.remove(arrs[i - M]);
            window.add(arrs[i]);
            smallestCount = 0;
            sum = 0;
            for (int x: window) {
                if (smallestCount == k) break;
                sum += x;
                smallestCount++;
            }
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        //Find the sum of K smallest element in all subarrays of size M.
        int[] arr = new int[]{3, 1, 4, 5, 7, 8,11};
        int M=4, k=3;
        List<Integer> result = sumOfSmallestElementInSubarray(arr, M, k);
        System.out.println(result); //[8, 10, 16, 20]
    }
}
