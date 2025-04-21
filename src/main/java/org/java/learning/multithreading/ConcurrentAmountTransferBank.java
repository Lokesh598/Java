package org.java.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentAmountTransferBank {

    private double balance;
    private final Lock lock = new ReentrantLock();

    public ConcurrentAmountTransferBank(double balance) {
        this.balance = balance;
    }

    public void updateBalance(double amount) {
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

class AccountUpdateTask implements Runnable {
    private final ConcurrentAmountTransferBank account;
    private final double amount;

    public AccountUpdateTask(ConcurrentAmountTransferBank account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.updateBalance(amount);
        System.out.println(Thread.currentThread().getName() + ": Updated balance to " + account.getBalance());
    }
}

class ConcurrentBalanceUpdate {
    public static void main(String[] args) {
        // Create a pool of bank accounts
        ConcurrentAmountTransferBank[] accounts = new ConcurrentAmountTransferBank[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new ConcurrentAmountTransferBank(1000);
        }

        // Create a thread pool to update balances concurrently
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Create tasks to update each account's balance
        for (ConcurrentAmountTransferBank account : accounts) {
            executor.execute(new AccountUpdateTask(account, 100)); // Update with some amount
            executor.execute(new AccountUpdateTask(account, -50)); // Withdraw some amount
        }

        // Shut down the executor
        executor.shutdown();

        // Wait for all tasks to complete
        while (!executor.isTerminated()) {
        }

        // Print final balances
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Final balance for account " + (i + 1) + ": " + accounts[i].getBalance());
        }
    }
}

