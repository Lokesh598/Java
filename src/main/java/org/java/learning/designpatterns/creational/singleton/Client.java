package org.java.learning.designpatterns.creational.singleton;


/**
 * In multithreaded program instances will be different for different threads
 * means 2 singleton is created
 *
 * means in multithreaded we can miss the advantage of singleton.
 *
 * for this we will do slight change in singleton class
 */
public class Client {
    public static void main(String[] args) {

        SingleThreadedSingleton object = SingleThreadedSingleton.getConnectionString("mongodb");
        SingleThreadedSingleton obj = SingleThreadedSingleton.getConnectionString("mysql");

        System.out.println("if you see same string that mean singleton implementation is correct or else it is wrong");
        System.out.println(object.connectionString);
        System.out.println(obj.connectionString);

        System.out.println("result in multithreaded singleton using double-checked locking");
        Thread mongoThread = new Thread(new MongoDB());
        Thread mysqlThread = new Thread(new MySQL());

        mongoThread.start();
        mysqlThread.start();
    }

    static class MongoDB implements Runnable {
        @Override
        public void run() {
            MultithreadedSingleton object = MultithreadedSingleton.getConnectionString("mongodb");
            System.out.println(object.connectionString);
        }
    }
    static class MySQL implements Runnable {
        @Override
        public void run() {
            MultithreadedSingleton object = MultithreadedSingleton.getConnectionString("mysql");
            System.out.println(object.connectionString);
        }
    }
}
