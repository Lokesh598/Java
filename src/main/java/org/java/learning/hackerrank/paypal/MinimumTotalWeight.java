package org.java.learning.hackerrank.paypal;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Scanner;

public class MinimumTotalWeight {
//}

/**
 * You have n chocolates with weights given in an array weights[n], where weights[i] represents the weight of the ith chocolate. Each day, you can pick one chocolate, consume half of its weight (calculated as floor(weights[i]/2)), and keep the remaining portion. Calculate the minimum possible total weight of the chocolates after d' days. Note that you can eat from the same chocolate multiple times.
 *
 * Example:
 *
 * weights [30, 20, 25] d=4
 *
 *
 */


//public class ChocolateMinimizer {

    public static int findMinWeight(int[] weights, int d) {
        // Use a max heap to always pick the chocolate with the largest weight
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all weights to the heap
        for (int weight : weights) {
            maxHeap.add(weight);
        }

        // Consume chocolates for d days
        for (int i = 0; i < d; i++) {
            if (!maxHeap.isEmpty()) {
                int maxWeight = maxHeap.poll(); // Pick the heaviest chocolate
                int remainingWeight = maxWeight / 2; // Calculate remaining weight after eating
                if (remainingWeight > 0) {
                    maxHeap.add(remainingWeight); // Add the remaining portion back to the heap
                }
            }
        }

        // Calculate the total weight remaining
        int totalWeight = 0;
        while (!maxHeap.isEmpty()) {
            totalWeight += maxHeap.poll();
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        int[] weights = {30, 20, 25};
        int d = 4;
        System.out.println("Minimum Total Weight after " + d + " days: " + findMinWeight(weights, d));
    }
}


//import java.util.*;
//        import java.util.PriorityQueue;

class MinimumWeightChocolateBar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the chocolate bar weights as a space-separated string
        String[] input = scanner.nextLine().split(" ");
        PriorityQueue<Integer> num = new PriorityQueue<>(Collections.reverseOrder());
        for (String s : input) {
            num.add(Integer.parseInt(s));
        }

        // Input the number of divisions (d)
        int d = scanner.nextInt();

        // Call the function and print the result
        System.out.println(minimumWeight(num, d));

        scanner.close();
    }

    public static int minimumWeight(PriorityQueue<Integer> num, int d) {
        for (int i = 0; i < d; i++) {
            // Remove the maximum weight
            int maxWeight = num.poll();

            // Halve the maximum weight and add it back to the queue
            int reducedWeight = maxWeight - maxWeight / 2;
            num.add(reducedWeight);
        }

        // Calculate the sum of the queue
        int sum = 0;
        while (!num.isEmpty()) {
            sum += num.poll();
        }

        return sum;
    }
}
