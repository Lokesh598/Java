package org.java.learning.multithreading;

public class Synchronization {
    /**
     * Synchronization is a technique which is used to control the access of multiple threads to shared resources.
     * without synchronization, it is possible for one thread to
     * modify a shared variable while another thread is in the process of using or updating the same shared variable.
     * @param args
     */
    public static void main(String[] args) {
        Counter count = new Counter();
        //here count object is shared with multiple threads
        MyThread t1 = new MyThread(count);
        MyThread t2 = new MyThread(count);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.getCount());
    }
}

class MyThread extends Thread{
    private Counter counter;
    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increament();

        }
    }
}

class Counter {
    private int count = 0;
    //synchronized keyword is used to make the method thread safe
    //synchornized keyword is used to acquire the lock on the object
    public synchronized void increament() {
        //critical section
        //only one thread can access this section at a time
        count++;
    }
    /**
     * Race condition: when multiple threads try to access the shared resource at the same time
     * how to remove this: using synchronized block
     */
    /**
     * Mutual Exclusion: only one thread can access the shared resource at a time
     * this term referred to: synchronized block
     */

    /**
     * synchronized block
     */
    public void increament1() {
        synchronized (this) {
            count++;
        }
    }
    public int getCount() {
        return count;
    }
}
