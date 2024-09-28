package org.java.learning.problemsolving.sorting;

import java.util.Arrays;


class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {4,2,1,3};

        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}

class BubbleSort {
    public static int[] sortArray(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = i+1; j < n-1-i; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{1, 4, 2, 0})));
    }
}


class QuickSort {
    public static int[] quickSort(int[] arr, int p, int q) {
        if (p < q) {
            int m = partition(arr, p, q);
            quickSort(arr, p, m-1);
            quickSort(arr, m+1, q);
        }
        return arr;
    }

    public static int partition(int[] arr, int p, int q) {
        int pivot = arr[p];
        int i = p;
        for (int j = p+1; j <= q; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[p];
        arr[p] = tmp;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{1, 4, 2, 0}, 0, 3)));
    }
}

class MergeSort {
    public static int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, r, mid);
        }
        return arr;
    }

    public static void merge(int[] arr, int l, int r, int mid) {
        int x = mid-l+1;
        int y = r-mid;
        int[] a = new int[x];
        int[] b = new int[y];


        for (int i = 0; i < x; i++) {
            a[i] = arr[l+i];
        }
        for (int j = 0; j < y; j++) {
            b[j] = arr[mid+j+1];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < x && j < y) {
            if (a[i] <= b[j])
                arr[k++] = a[i++];
            else
                arr[k++] = b[j++];
        }
        while (i<x) {
            arr[k++] = a[i++];
        }
        while (j<y) {
            arr[k++] = b[j++];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{2,1,0,7,4}, 0, 4)));
    }
}

//find minimum element and swap it with first element
class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
