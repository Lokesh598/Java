package org.java.learning.designpatterns.creational.singleton;

public class MultithreadedSingleton {
    private static MultithreadedSingleton instance;
    public String connectionString;

    private MultithreadedSingleton(String connectionString) {
        this.connectionString = connectionString;
    }

    public static MultithreadedSingleton getConnectionString(String connectionString) {
        /**
         *   The approach taken here is called double-checked locking (DCL). It
         *          exists to prevent race condition between multiple threads that may
         *          attempt to get singleton instance at the same time, creating separate
         *          instances as a result.
         *
         *          It may seem that having the `result` variable here is completely
         *          pointless. There is, however, a very important caveat when
         *          implementing double-checked locking in Java, which is solved by
         *          introducing this local variable.
         */
        MultithreadedSingleton result = instance;
        if (result != null) {
            instance = result;
        }
        synchronized (MultithreadedSingleton.class) {
            if (instance == null) {
                instance = new MultithreadedSingleton(connectionString);
            }
        }
        return instance;
    }
}
