package org.java.learning.dsa;

import java.util.Arrays;
import java.util.Scanner;

public class StackDS {

    static class StackUsingArray {
        static int[] stack;
        static int top;
        private void push(int ele) {
            if (top+1 == stack.length) {
                System.out.println("stack is overflow");
            } else {
                top++;
                stack[top] = ele;
            }
        }
        private int getOrPeek(int top) {
            return stack[top];
        }

        private int pop() {
            int y = 0;
            if (top == -1) {
                System.out.println("stack underflow");
            } else {
                y = stack[top];
                top--;
            }
            return y;
        }
        public static void main(String[] args) {
            StackUsingArray stackUsingArray = new StackUsingArray();
            stack = new int[10];
//        Scanner sc = new Scanner(System.in);
//
//        int element = sc.nextInt();

            stackUsingArray.push(1);
            stackUsingArray.push(2);
            stackUsingArray.push(3);

            Arrays.stream(stack).forEach(System.out::print);


            System.out.println("Stack top element " + stackUsingArray.getOrPeek(top));
            System.out.println("Stack top element " + stackUsingArray.pop());
            System.out.println("Stack top element " + stackUsingArray.getOrPeek(top));
            System.out.println("Stack top element " + stackUsingArray.pop());
            System.out.println("Stack top element " + stackUsingArray.pop());

            Arrays.stream(stack).forEach(System.out::print);
        }
    }

    /**
     *
     * top variable will be a node
     */
    static class Top {
        int data;
        Top next;
        Top(int data, Top next) {
            this.data = data;
            this.next = next;
        }
    }

    static class StackUsingLinkedList {

    }
}
