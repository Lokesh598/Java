package org.java.learning.dsa.dynamicprogramming.zerooneknapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) throws Exception{
//        List<List<Integer>> x = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wts = new int[n];

        for(int i = 0; i<val.length; i++) {
            val[i] = sc.nextInt();
        }
        for (int i = 0; i<wts.length; i++) {
            wts[i] = sc.nextInt();
        }
        int w = sc.nextInt();

        int[][] tb = new int[n+1][w+1];
        for(int i = 1; i<tb.length; i++) {//i = playrs
            for(int j = 1; j<tb[0].length; j++) { //j = balls
                if(j >= wts[i-1]) {
                    int rCap = j - wts[i-1];
                    if(tb[i-1][rCap] + val[i-1] > tb[i-1][j]) {
                        tb[i][j] = tb[i-1][rCap] + val[i-1];
                    } else {
                        tb[i][j] = tb[i-1][j];// when i dosnt bat
                    }
                } else {
                    tb[i][j] = tb[i-1][j];// when i dosnt bat
                }
            }
        }
        System.out.println(tb[n][w]);
    }
}
