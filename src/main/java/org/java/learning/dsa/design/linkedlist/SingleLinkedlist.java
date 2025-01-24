package org.java.learning.dsa.design.linkedlist;

public class SingleLinkedlist {

    public ListNode createNode(int val) {
        return new ListNode(val);
    }
    public void linkNodes(ListNode node1, ListNode node2) {
        node1.next = node2;
    }
    public static void main(String[] args) {
        SingleLinkedlist sll = new SingleLinkedlist();
        ListNode node1 = sll.createNode(1);
        ListNode node2 = sll.createNode(2);
        ListNode node3 = sll.createNode(3);
        sll.linkNodes(node1, node2);
        sll.linkNodes(node2, node3);
        ListNode temp = node1;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}
