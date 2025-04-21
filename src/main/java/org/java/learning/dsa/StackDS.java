package org.java.learning.dsa;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackDS {

    /**
     * Stack implementation
     */
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

    static class StackUsingLinkedList {
        class Node {
            int data;
            Node next;
            Node (int data) {this.data = data;}
        }

        Node head;
        int size;
        StackUsingLinkedList() {
            head = null;
            size = 0;
        }

        void push(int x) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            size++;
        }

        int pop() {
            if (head == null) return Integer.MAX_VALUE;
            int s = head.data;
            Node newNode = head;
            head = head.next;
            size--;
            return s;
        }
        int peek() {
            if (head == null) return Integer.MAX_VALUE;
            return head.data;
        }
        int size() {
            return size;
        }
        boolean isEmpty() {
            return head == null;
        }

        public static void main(String[] args) {
            StackUsingLinkedList stL = new StackUsingLinkedList();

            stL.push(2);
            stL.push(3);
            stL.push(4);

            System.out.println(stL.size());
            System.out.println(stL.isEmpty());
            System.out.println(stL.peek());
            System.out.println(stL.pop());
            System.out.println("Peek Element : "+stL.peek());

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

    private static void insertInStackByOrder(Stack<Integer> st, int ele) {
        if (st.empty()) {
            st.push(ele);
            return;
        }
        int tmp = st.pop();
        insertInStackByOrder(st, ele);
        st.push(tmp);
    }
    private static void helper(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int ele = stack.pop();
        helper(stack);
        insertInStackByOrder(stack, ele);
    }

    private Stack<Integer> reverseStack(Stack<Integer> st) {
        helper(st);
        return st;
    }

    private static void insertInStackBySortedOrder(Stack<Integer> st, int ele) {
        if (st.empty() || st.peek()<=ele) {
            st.push(ele);
            return;
        }
        int tmp = st.pop();
        insertInStackBySortedOrder(st, ele);
        st.push(tmp);
    }

    private static void helperSort(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int ele = stack.pop();
        helperSort(stack);
        insertInStackBySortedOrder(stack, ele);
    }

    private Stack<Integer> sortStack(Stack<Integer> st) {
        helperSort(st);
        return st;
    }

    public static void main(String[] args) {
        StackDS ds  = new StackDS();
        Stack<Integer> st = new Stack<>();
        st.push(11);
        st.push(2);
        st.push(32);
        st.push(3);
        st.push(41);

        ds.reverseStack(st);
        System.out.println(st);
        ds.sortStack(st);
        System.out.println(st);
    }
}
