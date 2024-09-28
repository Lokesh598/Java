package org.java.learning.problemsolving.searching;


import java.util.Arrays;

class BinarySearch {
    public static int binarySearch (int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while (left <= right) {
            int mid = (right + left)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 5}, 7));
    }
}
