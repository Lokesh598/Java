package org.java.learning.servicebasedproblems;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class JavaArray {

    /**
     * print 2nd smallest element in an given array with using Streams and without streams.
     *
     */
    private int secondSmallestNumber(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secmin = Integer.MAX_VALUE;

        for (int num : arr) {
            if (min > num) {
                min = num;
                secmin = min;
            } else if (num < secmin && num != min) {
                secmin = num;
            }
        }
        return secmin;
    }

    /**
     * Write a program that finds and prints the integers from the array whose squares
     * are also present in the array.
     */
    private List<Integer> findNumberWhosSquareIsPresentInArray (int[] nums) {
        Set<Integer> st = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            st.add(num);
        }
        for (int num:nums) {
            if (num == 1) continue;
            if (st.contains(num*num)) {
                res.add(num);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        JavaArray javaArray = new JavaArray();
        System.out.println(javaArray.secondSmallestNumber(new int[] {1, -1,-1,0,0,2, 3, 4}));
        System.out.println(javaArray.findNumberWhosSquareIsPresentInArray(new int[] {1, 4, 5, 9, 15, 16, 25, 30}));
    }
}
