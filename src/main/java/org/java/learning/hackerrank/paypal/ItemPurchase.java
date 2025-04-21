package org.java.learning.hackerrank.paypal;
import java.util.PriorityQueue;
/**
 *
 * A shop in HackerMall has n items where the price of the ith item is price[i]. A frequent customer has m discount coupons. If x discount coupons are used on the ith item, its price is reduced to the integer floor(price[i]/2x), e.g. floor(3/21) = floor(1.5) = 1.
 *
 * Find the minimum amount needed to purchase all the items of the shop using at most m coupons.
 *
 * Example
 *
 * Consider n = 2, price = [2, 4], m = 2.
 *
 * The optimum solution:
 *
 * • Purchase item 1 for 2.
 *
 * • Use 2 coupons on item 2, so the discounted price is 4/22-4/4=1.
 *
 * The amount required = 2 + 1 = 3.
 *
 * Function Description
 *
 * Complete the function findMinimumPrice in the editor below.
 *
 * findMinimumPrice has the following parameters:
 *
 * int price[n]: the original prices of the items int m: the number of discount coupons
 */
public class ItemPurchase {
//}
//
//
//public class MinimumPriceCalculator {

    static class Item implements Comparable<Item> {
        long reduction; // The benefit of using one more coupon
        long originalPrice; // Original price of the item
        int couponsUsed; // Number of coupons already used on this item

        public Item(long reduction, long originalPrice, int couponsUsed) {
            this.reduction = reduction;
            this.originalPrice = originalPrice;
            this.couponsUsed = couponsUsed;
        }

        @Override
        public int compareTo(Item other) {
            // Max-heap based on reduction
            return Long.compare(other.reduction, this.reduction);
        }
    }

    public static long findMinimumPrice(int[] price, int m) {
        // Priority queue to act as a max-heap
        PriorityQueue<Item> maxHeap = new PriorityQueue<>();

        // Initialize the heap with initial reductions
        for (int p : price) {
            long initialReduction = p - (p / 2);
            maxHeap.add(new Item(initialReduction, p, 1));
        }

        // Distribute m coupons
        for (int i = 0; i < m; i++) {
            if (maxHeap.isEmpty()) break;

            // Get the item with the highest reduction
            Item current = maxHeap.poll();

            // Calculate the new reduction after applying one more coupon
            long newPrice = current.originalPrice / (1L << current.couponsUsed);
            long nextPrice = current.originalPrice / (1L << (current.couponsUsed + 1));
            long newReduction = newPrice - nextPrice;

            // Add the updated item back to the heap
            maxHeap.add(new Item(newReduction, current.originalPrice, current.couponsUsed + 1));
        }

        // Calculate the total price
        long totalCost = 0;
        while (!maxHeap.isEmpty()) {
            Item current = maxHeap.poll();
            totalCost += current.originalPrice / (1L << (current.couponsUsed - 1));
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] price = {2, 4};
        int m = 2;

        long result = findMinimumPrice(price, m);
        System.out.println("Minimum amount needed: " + result); // Output: 3
    }
}

