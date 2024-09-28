package org.java.learning.multithreading;

public class WithoutThread {
    public void display() {
        int i = 1;
        while (true) {
            System.out.println(i++ + " Hello World");
        }
    }

    public static void main(String[] args) {
        WithoutThread wt = new WithoutThread();
        wt.display();
        int i = 0;
        while (true) {
            System.out.println(i++ + " Hello Java");
        }
    }
}
