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

        // in lis solution we have to make a lis array and need to fill it. at last we get the max out of it.

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
        LIS l = new LIS();
        System.out.println(l.LIS(n, n.length));
        System.out.println(longestSubsequence(n.length, n));
    }

    public int LIS(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = 1;//no small elements before it.

        for (int i = 1; i < n; i++) {
            lis[i] = 1; // assigning a value, later we will reassign in it.

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        int res = lis[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }
}
