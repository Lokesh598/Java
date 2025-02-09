package org.java.learning.dsa;

import java.util.*;
import java.util.LinkedList;

public class QueueDS {

    /**
     * ADT - enqueue, dequeue
     *
     * pointers - front, rear
     */
    static class QueueUsingArray {

    }

    /**
     * kth the largest element
     *
     * similarly kth the smallest element can be found
     */
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        return pq.peek();
    }

    /**
     * how many way we can create queue
     * @param args
     */
    public static void main(String[] args) {
        QueueDS queueDS = new QueueDS();
        int[] arr = new int[] {1,2,3,10, 12, 13};

        Queue<Integer> queue2 = new ArrayDeque<>();
        //1. using linkedlist
        Queue<Integer> queue = new LinkedList<>();

        //2. using priority queue
        Queue<Integer> queue1 = new PriorityQueue<>();

        //3. priority queue, bydefault it is min heap in java
        PriorityQueue<Integer> minHeapPriorityQueue = new PriorityQueue<>(); //min heap
        PriorityQueue<Integer> maxHeapPriorityQueue = new PriorityQueue<>(Collections.reverseOrder()); //max heap

        maxHeapPriorityQueue.add(10);
        maxHeapPriorityQueue.add(20);
        maxHeapPriorityQueue.add(5);

        System.out.println(maxHeapPriorityQueue.peek());

        System.out.println(queueDS.kthLargestElement(arr, 2));
    }
}
