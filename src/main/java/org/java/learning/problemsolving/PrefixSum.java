package org.java.learning.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSum {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1, 2, 3, 5, 4);
        List<Integer> prefixSum = new ArrayList<>();
        Solution sol = new Solution();

        sol.computePrefixSum(arrayList, prefixSum);
        System.out.println(sol.getSubArraySum(prefixSum, 1, 3));
        prefixSum.forEach(System.out::println);
    }
}

class Solution {
    public void computePrefixSum(List<Integer> arrayList, List<Integer> prefixSum) {
        int n = arrayList.size();
        //The prefix sum of the first element is the element itself
        prefixSum.add(0, arrayList.get(0));

        //compute prefix for remaining elements
        for (int i = 1; i < n; i++) {
            prefixSum.add(i, prefixSum.get(i-1) + arrayList.get(i));
        }
    }

    public int getSubArraySum(List<Integer> prefixSum, int start, int end) {
        if (start == 0)
            return prefixSum.get(end);
        return prefixSum.get(end) - prefixSum.get(start);
    }
}
