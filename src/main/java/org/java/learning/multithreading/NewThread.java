package org.java.learning.multithreading;

public class NewThread extends  Thread{
    int value;
//    public NewThread (int x) {
//        this.value = x;
//    }

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

class Runner {

    static NewThread x = new NewThread();

    static Thread t = new Thread(x);

    public static void main(String[] args) {
        t.start();
    }
}
