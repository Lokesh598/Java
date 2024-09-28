package org.java.learning.multithreading;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = new Runnable() {//annonymous class, separate class na banani pade issiliye Runnable interface ka object banaya
            @Override
            public void run() {
                account.withdraw(10);
            }
        };
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        thread1.start();
        thread2.start();
    }
}

class BankAccount {

    private int balance = 100;

    //using locks
    private final Lock lock = new ReentrantLock(); //kind of key to access the resource

    /**
     * we pass true in ReentrantLock constructor to make it fair lock
     * @param amount
     */
//    lock()
//    trylock()
//    trylockwithtime()
//    unlock()

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is about to withdraw" + amount);
        try {
            //lock.lock();//thread will wait here until it gets the lock
            if (lock.tryLock(10000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " proceeding to withdraw");
                    try {
                        Thread.sleep(3000); //simulate the time taken to complete the withdraw
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed the withdraw. Remaining balance" + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock(); //release the resource
                    }

                } else {
                    System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
                }
            } else {
                System.out.println("Sorry, resource is locked by another thread. " + Thread.currentThread().getName() + " cannot proceed");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*
    //shared resource so we will make this method synchronized
    //important: after making synchronized jab tak t1 iss method ko pura complete nai karta tab tak t2 is method ko access nai kar sakta
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is about to withdraw" + amount);
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " proceeding to withdraw");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completes the withdraw. Remaining balance" + balance);
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
        balance -= amount;
    }

     */
}
