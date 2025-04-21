package org.java.learning.dsa;

import java.util.HashSet;
import java.util.Set;

public class Strings {


    private int atoi(String str) {
        //remove trailing zero
        String newS = str.trim();

        int res = 0;


        int sign = 1, i = 0;
        if (newS.charAt(i) == '-' || newS.charAt(i) == '+') {
            sign = newS.charAt(0)=='-'?-1:1;
            i++;
        }
        while (i<newS.length() && (newS.charAt(i) >= '0' && newS.charAt(i) <= '9')) {
            int digit = (newS.charAt(i)-'0')*sign;
//            if(sign==1 && (res>Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && digit>Integer.MIN_VALUE%10))) return Integer.MIN_VALUE;
//            if(sign==-1 &&(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && digit<Integer.MIN_VALUE%10))) return Integer.MIN_VALUE;
            res = res*10+digit;
            i++;
        }

        System.out.println(res);
        return res;
    }

    private int longestSubstringWithoutRepeatingCharacters(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }




    public static void main(String[] args) {
        Strings strings = new Strings();
        String str = "42";
        strings.atoi(str);
    }
}
