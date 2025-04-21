package org.java.learning.dsa.dynamicprogramming.dponstocks.leetcode;

import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int profit = 0;

        for(int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;

            profit = Math.max(profit, cost);
            min = Math.min(min, arr[i]);
        }
        return profit;
    }
}

/**
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int min = prices[0], cost = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            cost = prices[i] - min;
            if (cost > 0) {
                profit += cost;
            }
            min = prices[i];
        }
        return profit;
    }
}
