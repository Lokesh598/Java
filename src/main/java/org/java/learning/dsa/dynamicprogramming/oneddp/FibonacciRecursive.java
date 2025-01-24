package org.java.learning.dsa.dynamicprogramming.oneddp;

public class FibonacciRecursive {
    static int fibonacci(int n) {
        // your code here
        if(n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
