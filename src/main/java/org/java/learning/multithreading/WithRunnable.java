package org.java.learning.multithreading;

public class WithRunnable implements Runnable{
    @Override
    public void run() {
        int i = 1;
        while (true) {
            System.out.println(i++ + " Hello World");
        }
    }

    public static void main(String[] args) {
        WithRunnable wt = new WithRunnable();
        Thread t = new Thread(wt);
        t.start();
        int i = 0;
        while (true) {
            System.out.println(i++ + " Hello Java");
        }
    }
}

