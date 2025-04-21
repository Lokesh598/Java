package org.java.learning.dsa.recursion;


/**
 * condition for check
 * if (i < j && arr[i] > arr[j]), then count++
 *
 *
 *
 */
public class CountInversions {

    //Naive approach
    public int countInversionsNaive(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (i < j && nums[i] > nums[j] ) {
                    count++;
                }
            }
        }
        return count;
    }

    private int mergeSort(int[] arr, int lo, int hi) {
        int cnt = 0;
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            cnt += mergeSort(arr, lo, mid);
            cnt += mergeSort(arr, mid+1, hi);
            cnt += merge(arr, lo, mid, hi);
        }
        return cnt;
    }
    private int merge(int[] arr, int l, int mid, int r) {
        int m = mid - l + 1;
        int n = r - mid;
        int[] A = new int[m];
        int[] B = new int[n];
        for (int i = 0; i < m; i++) {
            A[i] = arr[i + l];
        }
        for (int j = 0; j < n; j++) {
            B[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = l;
        int cnt = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                arr[k++] = A[i++];
            } else {
                arr[k++] = B[j++];
                cnt += (m - i); // here is the change in merge sort code
            }
        }
        while (i < m) {
            arr[k++] = A[i++];
        }
        while (j < n) {
            arr[k++] = B[j++];
        }
        return cnt;
    }

    public int countInversionsOptimal(int[] nums) {

        // we can write a merge algorithm, in this algorithm we will compare the values and increase count
        return mergeSort(nums, 0, nums.length-1);

    }

    public static void main(String[] args) {
        CountInversions cntIn = new CountInversions();

        int result = cntIn.countInversionsOptimal(new int[] {5, 3, 2, 4, 1});

        System.out.println(result);
    }
}
