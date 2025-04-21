package org.java.learning.dsa.dynamicprogramming.oneddp;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * leetcode problem
 */
public class HouseRobber2 {
    static int[] dp;
    private static int rob(ArrayList<Integer> nums, int n) {
        if (n < 0) {
            return 0;
        }
        if(nums.size() == 1) return nums.get(nums.size());
        if(dp[n] != -1)
            return dp[n];
        dp[n] = Math.max(rob(nums, n - 2) + nums.get(n), rob(nums, n - 1));
        return dp[n];
    }

    public static int FindMaxSum(int[] nums, int n) {
        if(nums.length == 1) return nums[0];
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i != 0)
                a.add(nums[i]);
            if(i != nums.length-1)
                b.add(nums[i]);
        }
        int left = rob(a, a.size() - 1);
        Arrays.fill(dp, -1);
        int right = rob(b, b.size() - 1);
//        int right =
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(FindMaxSum(nums, 4));
    }
}
