package org.java.learning.dsa.array.prefix;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 9;
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 0;
        arr[5] = 5;

        NumArray numArray = new NumArray(arr);

        System.out.println(numArray.rangeSum(2,4));
    }

    static class NumArray {
        int[] preSum;
        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i-1];
            }
            this.preSum = nums;
        }
        public int rangeSum(int left, int right) {
            if (left == 0) {
                return preSum[right];
            }
            return preSum[right]-preSum[left-1];
        }
    }
}
