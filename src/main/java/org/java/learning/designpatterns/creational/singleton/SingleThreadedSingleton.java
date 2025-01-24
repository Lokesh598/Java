package org.java.learning.designpatterns.creational.singleton;

public class SingleThreadedSingleton {
    /**
     * a static variable
     * private constructor
     * global accessible method
     */

    private static SingleThreadedSingleton instance;
    public String connectionString;

    private SingleThreadedSingleton(String connectionString) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.connectionString = connectionString;
    }

    public static SingleThreadedSingleton getConnectionString(String connectionString) {
        if (instance == null) {
            instance = new SingleThreadedSingleton(connectionString);
        }
        return instance;
    }
}

