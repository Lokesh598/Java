package org.java.learning.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;

        while (left<=right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        int cnt=1;
        while (left<=right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                matrix[top][i] = cnt++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = cnt++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = cnt++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = cnt++;
                }
                left++;
            }

        }
        return matrix;
    }

    public static void main(String[] args) {
        Matrix object = new Matrix();
        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};

        object.spiralOrder(mat);
        int [][] res = object.generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
