package org.java.learning.dsa;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Array {

    class SecondLargest {
        public static int secondLargestNumber(int[] nums) {
            int max = Integer.MIN_VALUE;
            int secMax = Integer.MIN_VALUE;

            for (int num : nums) {
                if (num > max) {
                    secMax = max;
                    max = num;
                } else if (num < max && secMax < num) {
                    secMax = num;
                }
            }
            return secMax;
        }
    }

    class MaximumSubarraySum {
        public static int maximumSubarraySum(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int curSum = 0;
            for (int num : nums) {
                curSum += num;
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
                if (curSum < 0) {
                    curSum = 0;
                }
            }
            return maxSum;
        }
    }

    class MaximumSubarrayProduct {
        public int maxProduct(int[] nums) {
            int prod = Integer.MIN_VALUE, curProd = 1;
            for (int i = 0; i < nums.length; i++) {
                curProd *= nums[i];

                if (curProd > prod) {
                    prod = curProd;
                }
                if (curProd == 0) curProd = 1;
            }
            curProd = 1;
            for (int j = nums.length-1; j >= 0; j--) {
                curProd *= nums[j];
                if (curProd > prod) {
                    prod = curProd;
                }
                if (curProd == 0) curProd = 1;
            }
            return prod;
        }
    }

    class Searching {
        private static int binarySearch(int[] nums, int target) {
            int l = 0, r = nums.length-1;

            while (l < r) {
                int mid = l + (r-l)/2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            return -1;
        }

        /**
         * Problems on binary Search
         *
         *
         */

    }

    /**
     * sorting algorithm class
     */
    class Sort {

        /**
         * Quick Sort
         * @param arr
         * @param lo
         * @param hi
         */
        static void quickSort(int arr[], int lo, int hi) {
            if (lo < hi) {
                int m = partition(arr, lo, hi);
                quickSort(arr, lo, m-1);
                quickSort(arr, m+1, hi);
            }
        }

        static int partition(int arr[], int p, int q) {
            int i = p;
            int pivot = arr[p];
            for (int j = p+1; j<=q; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[p];
            arr[p] = tmp;
            return i;
        }

        /**
         * Merge Sort
         * @param arr
         * @param lo
         * @param hi
         */
        static void mergeSort(int[] arr, int lo, int hi) {
            if (lo < hi) {
                int mid = (lo + hi) / 2;
                mergeSort(arr, lo, mid);
                mergeSort(arr, mid+1, hi);
                merge(arr, lo, mid, hi);
            }
        }
        private static void merge(int[] arr, int l, int mid, int r) {
            int m = mid - l + 1;
            int n = r - mid;
            int[] A = new int[m];
            int[] B = new int[n];
            // int *A = new int[m];
            // int *B = new int[n];
            for (int i = 0; i < m; i++) {
                A[i] = arr[i + l];
            }
            for (int j = 0; j < n; j++) {
                B[j] = arr[mid + 1 + j];
            }
            int i = 0, j = 0, k = l;
            while (i < m && j < n) {
                if (A[i] <= B[j]) {
                    arr[k++] = A[i++];
                } else
                    arr[k++] = B[j++];
            }
            while (i < m) {
                arr[k++] = A[i++];
            }
            while (j < n) {
                arr[k++] = B[j++];
            }
        }

        private static void selectionSort(int[] arr) {
            //find index of min element
            for (int i = 0; i < arr.length-1; i++) {
                int minInd = i;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] < arr[minInd]) {
                        minInd = j;
                    }
                }
                int tmp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = tmp;
            }
        }

        /**
         * Start with the second element (index 1) as the key.
         * Compare the key with the elements before it.
         * If the key is smaller than the compared element, shift the compared element one position to the right.
         * Insert the key at the correct position.
         * Repeat the process for all elements in the array.
         * @param arr
         */
        private static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i-1;

                while (j >= 0 && arr[j] > key) {
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = key;
            }
        }

        private static void bubbleSort(int[] arr) {
            for ( int i = 0; i < 1; i++) {
                boolean swapped = false; //if array is already sorted
                //in each i, the largest element will be at the end
                for (int j = 0; j < arr.length-i-1; j++) { // -i because the last element is already sorted
                    if (arr[j] > arr[j+1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                        swapped = true;
                    }
                    if (!swapped) { //if array is already sorted
                        break;
                    }
                }
            }
        }

        private static void heapSort(int[] arr) {

        }

        public static void sortColors(int[] nums) {
            int i = 0, k = 0, j = nums.length-1;

            while (k <= j) {
                if (nums[k] == 0) {
                    int tmp = nums[k];
                    nums[k++] = nums[i];
                    nums[i++] = tmp;
                } else if (nums[k] == 2) {
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j--] = tmp;
                } else {
                    k++;
                }
            }
            System.out.println(nums.toString());
        }
    }

    /**
     * method to check prime number
     * @param number
     * @return
     */
    private static boolean checkPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i == 0) return false;
        }
        return true;
    }

    private static int[] findDuplicates(int[] nums) {
        /**
         * brute force
         */
        Set<Integer> st = new HashSet<>();
        int[] res = new int[nums.length/2];
        int j = 0;
        for (int num : nums) {
            if (st.contains(num)) {
                res[j++] = num;
            }
            st.add(num);
        }
        return res;
    }
    /**
     * If array is having only 1 duplicate
     *  nums = [1,3,4,2,2]
     */
    private static int singleDuplicate(int[] nums) {
        for (int num : nums) {
            int ind = Math.abs(num);
            if (nums[ind] < 0) {
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 4, 4, 5, 3, 2, -5, 0, 0, -1, 3};

        int x = SecondLargest.secondLargestNumber(arr);
        System.out.println("SecondLargest "+x);

        System.out.println("MaximumSubarraySum :"+MaximumSubarraySum.maximumSubarraySum(arr));

        Sort.sortColors(new int[] {1, 2, 2, 0, 1, 0});

        int[] res = Array.findDuplicates(arr);
        for (int num : res) {
            System.out.print(num);
        }
        /**
         * 1. reverse number
         * 2. check number is palindrome or not
         * 3. find prime numbers
         */
        int num = 121, numCopy = num;
        int revNum = 0;
        while (num != 0) {
            revNum = revNum*10 + num%10;

            num /=10;
        }
        System.out.println("Reverse number of "+numCopy+ " :"+revNum);

        if (numCopy == revNum)
            System.out.println("Given number "+numCopy+" is palindrome");


        for (int i = 0; i < arr.length; i++) {
            if (Array.checkPrimeNumber(arr[i])) {
                System.out.print(arr[i]+" ");
            }
        }


    }

    static class FrequencyCounter {
        public static void countFrequencies(int[] nums) {
            int n = nums.length;

            // Step 1: Use modulo to encode frequency in place
            for (int i = 0; i < n; i++) {
                int index = nums[i] % n;  // Get original value
                nums[index] += n;         // Increase count
            }
            for (int i : nums) {
                System.out.println(i);
            }
            // Step 2: Extract frequencies
            System.out.println("Element : Frequency");
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + " : " + (nums[i] / n));  // Extract count
            }
        }

        public static void main(String[] args) {
            int[] nums = {2, 3, 3, 2, 5};  // Elements must be within 1 to N
            countFrequencies(nums);
        }
    }

}
