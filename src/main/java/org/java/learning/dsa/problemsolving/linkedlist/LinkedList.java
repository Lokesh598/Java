package org.java.learning.dsa.problemsolving.linkedlist;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class PrintNodes {
    public static Node reverseList(Node head) {
        Node p = null;
        Node q = null;

        while (head!=null) {
            p = q;
            q = head;
            head = head.next;
            q.next = p;
        }
        return q;
    }

    public static void printNodes(Node head) {
        while (head.next!=null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.next = third;

        printNodes(head);
        Node reverseList = reverseList(head);
        printNodes(reverseList);
    }
}



