package org.java.learning.webflux;

public class Multithreading {


    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        Multi m = new Multi();
        Multi m1 = new Multi();

//        t1.start();
//        t2.run();
        m.run();
        m1.run();

    }
}

class Multi implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while(true) {
            System.out.println(i++);
        }
    }

    public static void main(String[] args) {
        Multi m = new Multi();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);

        t1.start();
//        t2.run();
        t2.start();
    }

}
