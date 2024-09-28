package org.java.learning.collection;

import java.util.*;
import java.util.stream.Collectors;

public class SetInterface {
    public static void useHashSet(List<Integer> list) {
//        Map set = new HashSet<>();
        HashSet<Integer> set = new HashSet<>(list);
        TreeSet<Integer> set1 = new TreeSet<>(list);
        for (int i: set) {
            System.out.println(i);
        }
        //tree set sort the elements by itself
        for (int i : set1) {
            System.out.print(i);
        }
        System.out.println();
        //sort the set
        set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        for (int i: set) {
            System.out.println(i);
        }
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 0, 4, 4, 5, 5, -1, 1, 2);
        useHashSet(list);
    }
}
