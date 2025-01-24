package org.java.learning.dsa.dynamicprogramming.oneddp;

/**
 * Input:
 * n = 6
 * a[] = {5,5,10,100,10,5}
 * Output: 110
 * Explanation: 5+100+5=110
 */
public class HouseRobber {
    static int[] dp;
    private static int rob(int[] nums, int n) {
        if (n < 0) {
            return 0;
        }
        if(dp[n] != -1)
            return dp[n];
        dp[n] = Math.max(rob(nums, n - 2) + nums[n], rob(nums, n - 1));
        return dp[n];
    }
    public static int FindMaxSum(int nums[], int n)
    {
        dp = new int[nums.length];
        for(int i = 0; i<dp.length; i++) {
            dp[i] = -1;
        }
        return rob(nums, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(FindMaxSum(nums, 4));
    }
}
