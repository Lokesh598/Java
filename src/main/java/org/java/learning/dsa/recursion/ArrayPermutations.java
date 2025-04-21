package org.java.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

    public void recursion(int ind, int[] nums, List<List<Integer>> res, List<Integer> ds, boolean[] flag) {

        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                ds.add(nums[i]);
                recursion(ind, nums, res, ds, flag);
                ds.remove(ds.size()-1);
                flag[i] = false;
            }

        }
    }

    public void optimizedRecursionUsingSwap(int ind, int[] nums, List<List<Integer>> res) {

        if (ind == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < nums.length; i++) {

            swap(i, ind, nums);
            optimizedRecursionUsingSwap(ind+1, nums, res);
            swap(i, ind, nums);
        }
    }
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> ds = new ArrayList<>();

        boolean[] flag = new boolean[nums.length];

        recursion(0, nums, res, ds, flag);
        optimizedRecursionUsingSwap(0, nums, res);

        return res;
    }
}
