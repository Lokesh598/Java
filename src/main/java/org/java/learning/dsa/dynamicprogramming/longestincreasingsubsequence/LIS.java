package org.java.learning.dsa.dynamicprogramming.longestincreasingsubsequence;

/**
 * Input:
 * N = 6
 * A[] = {5,8,3,7,9,1}
 * Output: 3
 * Explanation:Longest increasing subsequence
 * 5 7 9, with length 3
 */
public class LIS {
    static int longestSubsequence(int n, int a[])
    {
        // code here

        int[] dp = new int[n];
        int omax = 0;
        for(int i = 0; i < dp.length; i++) {

            int max = 0;
            for(int j = 0; j < i; j++) {
                if(a[j]<a[i]) {
                    if(dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
            if(dp[i] > omax) {
                omax = dp[i];
            }
        }
        return omax;
    }

    public static void main(String[] args) {
        int[] n = new int[]{5,8,3,7,9,1};
        System.out.println(longestSubsequence(n.length, n));
    }
}
