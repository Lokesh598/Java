package org.java.learning.collection;

import java.util.*;

public class ListInterface {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(0);
        list.add(9);
        list.add(4);

        LinkedListClass ll = new LinkedListClass();
        ArrayListClass l2 = new ArrayListClass();
        ll.printLinkedList(list);
        l2.printArrayList(list);
    }
}

class LinkedListClass {
    public void printLinkedList(List<Integer> list) {
        List arr = Collections.singletonList(list);
        System.out.println(arr);

        List<Integer> list1 = sortLinkedList(list);

        System.out.println(list1);

    }
    public static List<Integer> sortLinkedList(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
class ArrayListClass {
    public void printArrayList(List<Integer> list) {
        System.out.println(list);
        List<Integer> list1 = LinkedListClass.sortLinkedList(list);
        System.out.println(list1);
    }
}

class VectorClass {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);

        System.out.println(v);
    }
}

