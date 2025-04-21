package org.java.learning.dsa.recursion;


import java.util.*;

/**
 *
 * Leetcode
 *
 * Given an integer array nums that may contain duplicates, return all possible
 *
 * (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetSumII {

    // to solve this we can use two methods basically.
    // we can store all the subsets in the hashset, to remove duplicates.
    // this solution sligtly changes compared subsetsum, change here is , this will do backtrack here

    public void powerSet(int ind, int[] nums, List<Integer> st, List<List<Integer>> res) {


        int n = nums.length;
        // if (i == n) {
        //     res.add(new ArrayList<>(st));
        //     return;
        // }
        res.add(new ArrayList<>(st));
        for (int i = ind; i < n; i++) {
            if (i != ind && nums[i] == nums[i-1]) continue;
            st.add(nums[i]);
            powerSet(i+1, nums, st, res);
            st.remove(st.size()-1);
        }

        // powerSet(i+1, nums, st, res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        List<Integer> st = new ArrayList<>();
        Arrays.sort(nums); //to get duplicates side by side
        powerSet(0, nums, st, res);
        // for (ArrayList<Integer> s : set) {
        //     res.add(s);
        // }
        return res;
    }
}
