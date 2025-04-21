package org.java.learning.multithreading;

public class WithThread extends Thread{
    @Override
    public void run() {
        int i = 1;
//        while (true) {
//            System.out.println(i++ + " Hello World");
//        }
    }
}
class Solution {

    public static void main(String[] args) {
        WithThread wt = new WithThread();
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.println(t.getName());
        wt.start();
//        System.out.println(wt.getName());
    }



}
