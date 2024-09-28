package org.java.learning.problemsolving.slidingwindow;

public class MaxSumOfWindow {
    public static int maxSumOfSlidingWindow(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i+k-1 < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i+j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    //windowsliding
    public static int maxSumUsingSlidingWindow(int[] arr, int k) {
        int cur = 0;
        for (int i = 0; i<k; i++) {
            cur += arr[i];
        }
        int res = cur;
        for (int i = k; i < arr.length; i++) {
            cur = cur + arr[i] - arr[i-k];
            res = Math.max(res, cur);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 8, 30, -5, 20, 7};

        System.out.println(maxSumOfSlidingWindow(arr, 3));
        System.out.println(maxSumUsingSlidingWindow(arr,3));
    }
}
