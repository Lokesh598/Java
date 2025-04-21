package org.java.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, candidates, target, res, ans);

        return ans;
    }

    private void backtrack(int ind, int[] arr, int tar, List<Integer> res, List<List<Integer>> ans) {

        if (tar == 0) {  // Base case: valid combination
            ans.add(new ArrayList<>(res)); // Add a copy of res
            return;
        }

        if (ind == arr.length || tar < 0) { // Stop if index exceeds array length or target is negative
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i-1]) continue;
            res.add(arr[i]);
            backtrack(i+1, arr, tar-arr[i], res, ans);
            res.remove(res.size()-1);
        }

        // backtrack(i+1, arr, tar, res, ans);
    }
}
