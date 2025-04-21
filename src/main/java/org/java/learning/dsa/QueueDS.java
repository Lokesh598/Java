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
        enum Capacity {
            CAPACITY
        }
        int front;
        int rear;
        int[] arr;
        QueueUsingArray (int capacity) {
            arr = new int[capacity];
            front = -1;
            rear = -1;
        }

        public void add(int val) {
            if (front == -1) {
                front = 0;
            }
            rear++;
            arr[rear] = val;
        }

        public int poll() {
            int x = arr[front];
            front++;
            return x;
        }

        public int peek() {
            return arr[rear];
        }

        public int size() throws Exception {
            if (front>rear) {
                System.out.println("Queue underflow");
            }

            return rear - front + 1;
        }

        public boolean isEmpty() {
            if(rear == -1 && front == -1) {
                return true;
            } else if (front > rear) {
                return true;
            }
            return false;
        }

        static class QueueUsingStack {


        }

        public static void main(String[] args) throws Exception {

            QueueUsingArray q = new QueueUsingArray(10);

            q.add(1);
            q.add(2);
            q.add(3);

            System.out.println(q.peek());

            System.out.println(q.poll());
            System.out.println(q.poll());

            q.add(4);
            System.out.println(q.peek());

            System.out.println(q.isEmpty());

            System.out.println(q.size());

        }
    }

    static class CircularQueue {

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
