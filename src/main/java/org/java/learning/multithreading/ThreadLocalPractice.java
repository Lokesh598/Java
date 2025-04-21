package org.java.learning.multithreading;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * synchronized - keyword
 * deadlock
 * critical section
 *
 *
 * yield() | sleep() | join() | wait() | notify() | notifyAll() | run() | start() |
 *
 * join() - waits for another thread to finish
 */
public class ThreadLocalPractice {


    static class SynchronizedExample {
        private int counter = 0;


        //critical section
        public synchronized void increment() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }
    }

    static class SynchronizedThreadBlock implements Runnable {
        SynchronizedExample synchronizedExample;

        SynchronizedThreadBlock() {}

        SynchronizedThreadBlock(SynchronizedExample synchronizedExample) {
            this.synchronizedExample = synchronizedExample;
        }

        @Override
        public void run() {
            int x = 0;
            for (int i = 0; i < 20; i++) {
//                System.out.println(Thread.currentThread().getName()+":"+ x++);
                synchronizedExample.increment();
            }
        }

        public static void main(String[] args) {
            SynchronizedExample synchronizedExample = new SynchronizedExample();
            SynchronizedThreadBlock synchronizedThreadBlock = new SynchronizedThreadBlock(synchronizedExample);
            Thread thread1 = new Thread(synchronizedThreadBlock);
            Thread thread2 = new Thread(synchronizedThreadBlock);

            thread1.start();
            thread2.start();


            //main thread wait for both to finish

            try {
                thread1.join();
                thread2.join();// Wait for the thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("counter" + synchronizedExample.getCounter());
        }
    }


    static class ThreadWithRunnable implements Runnable {

        @Override
        public void run() {
            int x = 0;
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + x++);
            }
        }

        public static void main(String[] args) {
            ThreadWithRunnable threadWithRunnable = new ThreadWithRunnable();
            ThreadWithRunnable threadWithRunnable1 = new ThreadWithRunnable();

            Thread t = new Thread(threadWithRunnable);
            Thread t2 = new Thread(threadWithRunnable1);

            t.start();
            t2.start();
        }
    }


    static class ThreadPractice extends Thread {

        private Counter count;
        ThreadPractice(){}
        ThreadPractice(Counter count) {
            this.count = count;
        }
        @Override
        public void run() {
            int x = 0;
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + x++);
            }

        }

        private void simpleThread() {
            ThreadPractice threadPractice1 = new ThreadPractice();
            ThreadPractice threadPractice2 = new ThreadPractice();
            Thread thread1 = new Thread(threadPractice1);
            Thread thread2 = new Thread(threadPractice2);

            thread1.start();
            thread2.start();
        }

        public static void main(String[] args) {
            System.out.println(Thread.currentThread().getName());

            ThreadPractice t = new ThreadPractice();
            t.simpleThread();
        }
    }


    static class AtomicVolatile {
        private volatile boolean running = true;

        public void stop() {
            running = false;  // Change is immediately visible to other threads
        }

        public void run() {
            while (running) {
                // Do something
            }
            System.out.println("Stopped.");
        }


        private AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();  // Atomic operation
        }

        public int getCount() {
            return count.get();
        }
    }
}

