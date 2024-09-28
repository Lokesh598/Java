package org.java.learning.problemsolving.array;


class SecondLargest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,3,4};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > first) {
                second = first;
                first = value;
            } else if (value > second && value != first) {
                second = value;
            }
        }
        System.out.println(second);
    }
}

class KthLargestElement {
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
    public static int quickSelect(int[] arr, int low, int high, int x) {
        if (low == high) return arr[low];

        int m = partition(arr, low, high);
        if (m == x) {
            return arr[x];
        } else if (m > x) {
            return quickSelect(arr, low, m-1, x);
        } else {
            return quickSelect(arr, m+1, high, x);
        }
    }
    public static int kthLargestElement (int[] arr, int x) {
        return quickSelect(arr, 0, arr.length-1, arr.length-x);
    }
    public static void main(String[] args) {
        System.out.println(kthLargestElement(new int[]{1, 4, 2, 6, 7}, 2));
    }
}

class KthMinimumElement {
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
    public static int quickSelect(int[] arr, int low, int high, int x) {
        if (low == high) return arr[low];

        int m = partition(arr, low, high);
        if (m == x-1) {
            return arr[x-1];
        } else if (m > x-1) {
            return quickSelect(arr, low, m-1, x);
        } else {
            return quickSelect(arr, m+1, high, x);
        }
    }
    public static int kthMinimumElement (int[] arr, int x) {
        return quickSelect(arr, 0, arr.length-1, x);
    }
    public static void main(String[] args) {
        System.out.println(kthMinimumElement(new int[]{1, 4, 2, 6, 7}, 3));
    }
}

class RemoveDuplicates {
    public static int removeDuplicate (int[] arr) {
        int j = 0;
        for (int i = 1; i< arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};

        int i = removeDuplicate(arr);
        for (int j = 0; j < i; j++) {
            System.out.println(arr[j]);
        }
    }
}

