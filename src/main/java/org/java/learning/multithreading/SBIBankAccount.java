package org.java.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementing Money Transfer Using Multithreading
 */

class SBIBankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public SBIBankAccount(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

class TransferTask implements Runnable {
    private SBIBankAccount sourceAccount;
    private SBIBankAccount targetAccount;
    private double amount;

    public TransferTask(SBIBankAccount sourceAccount, SBIBankAccount targetAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (sourceAccount.withdraw(amount)) {
            targetAccount.deposit(amount);
            System.out.println(Thread.currentThread().getName() + ": Transferred " + amount + " successfully. New SBI balance: " + sourceAccount.getBalance());
        } else {
            System.out.println(Thread.currentThread().getName() + ": Failed to transfer " + amount + ". Insufficient balance in SBI account.");
        }
    }
}

class MoneyTransferSimulation {
    public static void main(String[] args) {
        // Initial balance in SBI account
        SBIBankAccount sbiAccount = new SBIBankAccount(1000);
        SBIBankAccount targetAccount = new SBIBankAccount(500);

        // Define the transfer amount
        double transferAmount = 100;

        // Create and start multiple threads to simulate concurrent transfers
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new TransferTask(sbiAccount, targetAccount, transferAmount), "Thread-" + (i + 1));
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final SBI balance: " + sbiAccount.getBalance());
        System.out.println("Final Target Account balance: " + targetAccount.getBalance());
    }
}
