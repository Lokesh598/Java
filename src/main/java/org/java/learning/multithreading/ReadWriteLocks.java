package org.java.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {
    public static void main(String[] args) {
        CounterReadWriteLock counter = new CounterReadWriteLock();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
//                counter.increament();
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + counter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    counter.increament();
                    System.out.println(Thread.currentThread().getName() + " incremented " + counter.getCount());
                }
            }
        };
        ThreadLocal threadLocal = new ThreadLocal();

        Thread thread1 = new Thread(writeTask, "Thread 1");
        Thread thread2 = new Thread(readTask, "Thread 2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CounterReadWriteLock {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    private int count = 0;

    public void increament() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

}
