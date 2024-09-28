package org.java.learning.multithreading;

public class Deadlock {
    // Resource 1
    private final Object resource1 = new Object();
    // Resource 2
    private final Object resource2 = new Object();

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        // Thread 1 tries to lock resource1 then resource2
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadlock.method1();
            }
        });

        // Thread 2 tries to lock resource2 then resource1
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadlock.method2();
            }
        });

        thread1.start();
        thread2.start();
    }

    // Method 1: Locks resource1 then tries to lock resource2
    public void method1() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + ": Locked resource1");

            // Simulate some work with resource1
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName() + ": Trying to lock resource2");
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + ": Locked resource2");
            }
        }
    }

    // Method 2: Locks resource2 then tries to lock resource1
    public void method2() {
        synchronized (resource2) {
            System.out.println(Thread.currentThread().getName() + ": Locked resource2");

            // Simulate some work with resource2
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName() + ": Trying to lock resource1");
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + ": Locked resource1");
            }
        }
    }
}

