package org.java.learning.multithreading;

public class SleepAndWait extends Thread{

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(i++ + " Hello World");
            try {
                Thread.sleep(3, 10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepAndWait sw = new SleepAndWait();
        Thread thread = new Thread(sw);
//        Thread.MIN_PRIORITY = 1;
//        Thread.MAX_PRIORITY = 10;
//        Thread.NORM_PRIORITY = 5;
        thread.start();
    }
}
