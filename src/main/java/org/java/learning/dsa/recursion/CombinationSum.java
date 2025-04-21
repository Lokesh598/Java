package org.java.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, res, ans);

        return ans;
    }

    private void backtrack(int i, int[] arr, int tar, List<Integer> res, List<List<Integer>> ans) {

        if (tar == 0) {  // Base case: valid combination
            ans.add(new ArrayList<>(res)); // Add a copy of res
            return;
        }

        if (i == arr.length || tar < 0) { // Stop if index exceeds array length or target is negative
            return;
        }

        if (arr[i] <= tar) {
            res.add(arr[i]);
            backtrack(i, arr, tar-arr[i], res, ans);
            res.remove(res.size()-1);
        }

        backtrack(i+1, arr, tar, res, ans);
    }
}
