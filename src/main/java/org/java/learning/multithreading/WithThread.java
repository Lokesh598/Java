package org.java.learning.multithreading;

public class WithThread extends Thread{
    @Override
    public void run() {
        int i = 1;
        while (true) {
            System.out.println(i++ + " Hello World");
        }
    }
}
class Solution {

    public static void main(String[] args) {
        WithThread wt = new WithThread();
        wt.start();
        int i = 0;
        while (true) {
            System.out.println(i++ + " Hello Java");
        }
    }
}
