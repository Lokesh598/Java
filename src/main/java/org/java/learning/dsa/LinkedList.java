package org.java.learning.dsa;


public class LinkedList {
    static class ListNode {
        private final int data;
        private ListNode next;

        ListNode (int data) {this.data = data;}
        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * reverse linked list
     * @param head
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;

        while (head != null) {
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        System.out.println("List in reverse order");
        printList(cur);
        return cur;
    }

    private ListNode reverseList2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
//        int cnt = left;
        while (left--!= 0) {
            if (left == 1) {
                break;
            }
            pre = pre.next;
        }

        ListNode cur = pre.next;

        for (int i = 0; i < right-left; i++) {
            ListNode forw = cur.next;
            cur.next = forw.next;
            forw.next = pre.next;
            pre.next = forw;
        }
        return dummy.next;
    }

    private void printList(ListNode head) {

        while (head!=null) {
            System.out.print(head.data + "->");
            head = head.next;
        }

        System.out.print("null");
        System.out.println();

    }

    /**
     * insert node at given position
     *
     * @param head
     * @param pos
     */
    private ListNode insertNode(ListNode head, int pos, int val) {
        if (pos == 0) {
            ListNode newHead = new ListNode(val, null);
            newHead.next = head;
            head = newHead;
            printList(newHead);
            return head;
        }
        //pos = 2
        int cnt = pos;
        if (pos > 0) {
            ListNode newHead = new ListNode(val, null);
            ListNode frd = head;
            while (cnt-- != 0) {
                if (cnt == 0) {
                    newHead.next = frd.next;
                    frd.next = newHead;
                }
                frd = frd.next;
            }
            printList(head);
        }
        return head;
    }

    private int returnPostionIfValExist(ListNode head, int val) {
        ListNode tmp = head;
        int cnt = 1;
        while (tmp!=null) {
            if (tmp.data == val) {
                break;
            }
            cnt++;
            tmp = tmp.next;
        }
        return cnt;
    }

    private ListNode deleteNode(ListNode head, int val) {
        ListNode tmp = head;
        if (tmp.data == val) {
            System.out.println("list after removing " + val + " value node");
            printList(head.next);
            return head.next;
        }
        while (tmp != null && tmp.next != null) {
            if (tmp.next.data == val) {
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        System.out.println("list after removing " + val + " value node");
        printList(head);
        return head;
    }
    private ListNode findMidNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Merge Sort on linkedlist
     * @param node
     * @return
     */
    private ListNode sortLinkedList(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode frnd = node;
        ListNode mid = findMidNode(frnd);

        while (frnd != mid) {
            if (frnd.next == mid) {
                break;
            }
            frnd = frnd.next;
        }
        frnd.next = null;

        ListNode l1 = sortLinkedList(node);
        ListNode l2 = sortLinkedList(mid);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode tmp = null;

        if (list1 == null ) return list2;
        else if (list2 == null)
            return list1;

        if (list1.data <= list2.data) {
            tmp = list1;
            tmp.next = mergeTwoLists(list1.next, list2);
        } else {
            tmp = list2;
            tmp.next = mergeTwoLists(list1, list2.next);
        }
        return tmp;
    }

    private ListNode insertionSort() {
return null;
    }
    /**
     * Linked List driver or runner method
     * <p>
     * searching ✔, inserting ✔, delete ✔
     * <p> </p>
     * sorting
     * @param args
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ListNode head = new ListNode(1, null);
        ListNode node1 = new ListNode(2, null);
        head.next = node1;
        node1.next = new ListNode(3, null);
        node1.next.next = new ListNode(4, null);

        linkedList.printList(head);
        head = linkedList.insertNode(head, 0, 5);
        head = linkedList.insertNode(head, 2, 6);

        head = linkedList.reverseList(head);

        int pos = linkedList.returnPostionIfValExist(head, 4);
        System.out.println("Given node value position is " + pos);

        head = linkedList.deleteNode(head, 4);

        linkedList.printList(linkedList.sortLinkedList(head));
        linkedList.printList(linkedList.reverseList2(head, 2, 3));
    }

    static class DoublyListNode {
        private final int data;
        DoublyListNode pre;
        DoublyListNode next;
        DoublyListNode(int data) {
            this.data = data;
        }
        DoublyListNode(int data, DoublyListNode pre, DoublyListNode next) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }

        public static void printList(DoublyListNode node) {
            System.out.print("null");
            while (node!=null) {
                System.out.print("<-");
                System.out.print(node.data +"->");
                node = node.next;
            }
            System.out.println("null");
        }

        private static DoublyListNode addNewNodeAtLast(DoublyListNode node, int val) {
            DoublyListNode newNode = new DoublyListNode(5);
            DoublyListNode tmp = node;
            while (tmp.next!=null) {
                tmp = tmp.next;
            }

            tmp.next = newNode;
            newNode.pre = tmp;
            newNode.next = null;

            return node;
        }

        public static void main(String[] args) {
            DoublyListNode head = new DoublyListNode(1);
            DoublyListNode node1 = new DoublyListNode(2);
            DoublyListNode node2 = new DoublyListNode(3);
            DoublyListNode node3 = new DoublyListNode(4);

            head.next = node1;
            head.pre = null;
            node1.pre = head;
            node1.next = node2;
            node2.pre = node1;
            node2.next = node3;
            node3.pre = node2;
            node3.next = null;

            DoublyListNode.addNewNodeAtLast(head, 5);
            DoublyListNode.printList(head);

        }
    }

    static class CircularListNode {
        private final int data;
        private boolean flag;
        CircularListNode next;
        CircularListNode(int data, boolean flag) {
            this.data = data;
            this.flag = flag;
        }
        CircularListNode(int data, boolean flag, CircularListNode next) {
            this.data = data;
            this.flag = flag;
            this.next = null;
        }

        private static void printList(CircularListNode node) {

            while (node.flag != true) {
                System.out.print(node.data + "->");
                node.flag = true;
                node = node.next;
            }
        }

        public static void main(String[] args) {
            CircularListNode head = new CircularListNode(1, false);
            CircularListNode head1 = new CircularListNode(2, false);
            CircularListNode head2 = new CircularListNode(3, false);

            head.next = head1;
            head1.next = head2;
            head2.next = head;

            CircularListNode.printList(head);
        }
    }

}