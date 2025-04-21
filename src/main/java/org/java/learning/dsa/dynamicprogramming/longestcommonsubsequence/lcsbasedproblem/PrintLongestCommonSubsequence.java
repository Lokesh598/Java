package org.java.learning.dsa.dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * C++ solution
 * vector<string> print_longest_common_subsequence(string s, string t)
 *                {
 * 		    // Code here
 * 		  //  int len = lcs(s, t, s.size(), t.size());
 * 		   vector<string> res;
 * 		   int m = s.size(), n = t.size();
 * 		   int dp[m+1][n+1];
 * 	        for(int i = 0; i<m+1; i++) {
 * 	            for(int j = 0; j<n+1; j++) {
 * 	                if(i == 0 || j == 0)
 * 	                    dp[i][j] = 0;
 *                }
 *            }
 * 	        for(int i = 1; i<m+1; i++) {
 * 	            for(int j = 1; j<n+1; j++) {
 * 	                if(s[i-1] == t[j-1]) {
 * 	                    dp[i][j] = 1+dp[i-1][j-1];
 *                    } else {
 * 	                    dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
 *                    }
 *                }
 *            }
 * 	       // return dp[m][n];
 * 		    string s1 = "";
 * 		    int i = s.size(), j = t.size();
 *
 * 		    while(i>0 && j>0) {
 * 		        if(s[i-1] == t[j-1]){
 * 		            s1.push_back(s[i-1]);
 * 		            i--;
 * 		            j--;
 *                } else {
 * 		            if(dp[i][j-1] > dp[i-1][j]) {
 * 		                j--;
 *                    }
 * 		          //  else if (dp[i][j-1] == dp[i-1][j]) {
 *
 * 		          //  }
 * 		            else {
 * 		                i--;
 *                    }
 *                }
 *            }
 * 		    reverse(s1.begin(), s1.end());
 *
 * 		    res.push_back(s1);
 * 		    return res;
 *        }
 */
public class PrintLongestCommonSubsequence {

    public static List<String> printLongestCommonSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                lcs.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j-1] > dp[i-1][j]) {
                j--;
            } else {
                i--;
            }
        }

        lcs.reverse();

        List<String> result = new ArrayList<>();
        result.add(lcs.toString());
        return result;
    }

    public static void main(String[] args) {
        String s = "ABCBDAB";
        String t = "BDCAB";
        List<String> lcsResult = printLongestCommonSubsequence(s, t);
        System.out.println("Longest Common Subsequence: " + lcsResult.get(0));
    }
}
