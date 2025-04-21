package org.java.learning.dsa.string;

import java.util.Arrays;
import java.util.Collections;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));}

    private boolean checkPalindrome(String s) {
        char[] c = s.toCharArray();
        char[] rc = new char[c.length];
        int l = 0, r = c.length - 1;
        while (l < r) {
            rc[l] = c[r];
            rc[r] = c[l];
            l++;
            r--;
        }
        if (c == rc) {
            return true;
        }
        return false;
    }

    public static String shortestPalindrome(String s) {
return "";
    }
}
