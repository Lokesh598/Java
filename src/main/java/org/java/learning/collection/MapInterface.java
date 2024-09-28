package org.java.learning.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MapInterface {
    public static void useHashMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        //add array elements in hashmap
        for (int n: list) {
            map.put(i++, n);
        }
        //iterate over the map
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            System.out.println("key " + it.getKey() + " value "+it.getValue());
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        useHashMap(list);
    }
}

class HashMapClass {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

    }
}
