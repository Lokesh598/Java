package org.java.learning.dsa.string;

import java.util.*;

/**
 * https://www.digitalocean.com/community/tutorials/java-string-interview-questions-and-answers#write-a-java-program-to-print-all-permutations-of-a-string
 */


/**
 * What are some different ways to create a String object in Java?
 */

class StringCreation {
    public static void main(String[] args) {
        String str = new String("Hello"); // using new keyword, heap // we can reasign in this case
        String str1 = "Hello"; // string litteral -> string pool memory // we can not reasign value to this

        str = str.concat(" World");
        str = "Hello World!!";
        if (str.charAt(2) == str.charAt(9))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
        str1.concat(" World java");
        System.out.println(str1);
        System.out.printf(str);
    }
}

/**
 * Write a Java method to check if an input string is a palindrome.
 */

class Palindrome {
    public static void main(String[] args) {
        String str = "Lokesh";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str) {

        String reverseStr = reverseString (str);
        if (str.equals(reverseStr)) {
            return true;
        }
        return false;
    }
    public static String reverseString (String st) {
        char[] charArr = st.toCharArray();
        int left = 0;
        int right = st.length()-1;
        while (left < right) {
            char tmp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = tmp;
            left++;
            right--;
        }
        return new String(charArr);
    }
}

class StringProblemsPractice {
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(isPalindrome);
    }
    public static boolean isPalindrome(String S) {
        int s = 0, l = S.length()-1;

        while (s <= l) {
            char currFirst = S.charAt(s);
            char currLast = S.charAt(l);
            if (!Character.isLetterOrDigit(currFirst)) s++;
            else if (!Character.isLetterOrDigit(currLast)) l--;
            else if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) return false;
            else {
                s++; l--;
            }
        }
        return true;
    }
}

class Anagram {
    public static boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);

        String s1 = new String(charS);
        String s2 = new String(charT);

        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}

//using stringbuilder
class Palindrome1 {
    public static void main(String[] args) {
        String str = "Lokesh";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (str.equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }
}

/**
 * Write a Java method that will remove a given character from a string object.
 * How can you make a String upper case or lower case in Java?
 * What is the String subSequence method?
 *
 * How do you compare two strings in a Java program? using comparable
 * How do you convert a String to a character array in Java?
 * How do you convert a String to a byte array in Java?
 */

class RemoveChar {
    public static void main(String[] args) {
        String str = "Lokesh";
        String str1 = "Lokes";
        char c = 'l';

        removeChar(str, c);

        System.out.println(str.subSequence(0,3));
        System.out.println(str == str1);
        System.out.println(str.equals(str1));
        System.out.println(str.compareTo(str1));
        System.out.println(str.getBytes());
        System.out.println(Arrays.toString(str.getBytes()));
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));
//        System.out.println(String.valueOf());
    }
    public static void removeChar (String str, char c) {
        if (str == null) return;
        System.out.println(str.toLowerCase(Locale.ROOT).replaceAll(Character.toString(c), ""));
    }
}

/**
 * Write a Java program to print all permutations of a string.
 *
 */

class Permutation {

}

/**
 * Write a Java function to find the longest palindrome in a given string.
 */

/**
 * What are the differences between String, StringBuffer, and StringBuilder in Java?
 *
 * A String object is immutable and final in Java, so whenever you manipulate a String object,
 * it creates a new String object. String manipulations are resource consuming,
 * so Java provides two utility classes for string manipulations, StringBuffer and StringBuilder.
 * StringBuffer and StringBuilder are mutable classes.
 * StringBuffer operations are thread-safe and synchronized, while StringBuilder operations are not thread-safe.
 * You should use StringBuffer in a multi-threaded environment and use StringBuilderin a single-threaded environment.
 * StringBuilder performance is faster than StringBuffer because of no overhead of synchronization.
 */

/**
 * advantages of string immutable in java -
 *
 *     String pool is possible because String is immutable in Java.
 *     It increases security because any hacker can’t change its value and it’s used for storing sensitive information
 *     such as a database username or password.
 *     Since String is immutable, it’s safe to use in multi-threading and you don’t need any synchronization.
 *     Strings are used in Java class loaders and immutability provides assurance that the correct class is getting
 *     loaded by the ClassLoader class.
 */

/**
 * how to split string in java?
 *
 */

class StringSplit {
    public static void main(String[] args) {
        String str = "ThisIsMyString";

        String newStr = Arrays.toString(str.split("\"(?=[A-Z])\""));
//        String newStr = Arrays.toString(str.split(""));

        System.out.println(newStr);

    }
}

class FindStringMatch {

    public boolean findMatch(String s, String t, int k) {

        int len = s.length();
        int subSlen = len/k;
        List<String> str = new ArrayList<>();
        for (int i = 0; i < len; ) {
            str.add(s.substring(i, i+subSlen));
//            String subS = s.substring(i, i+subSlen);


            i = i + subSlen;

//            for (int j = 0; j < subSlen; j++) {
//
//            }

        }
        System.out.println(str);



        return true;
    }

    public static void main(String[] args) {
        FindStringMatch c = new FindStringMatch();

        c.findMatch("aabbcc", "bbaacc", 2);
    }
}