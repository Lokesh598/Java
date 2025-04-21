package org.java.learning.oops.string;

/**
 * CharSequence - this is interface, all 3 categories of string implements it.
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = new String();

        String string = "hello";

        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append(" world");

        System.out.println(stringBuilder);
        System.out.println(string+" world");

        String tarnsformedString = String.valueOf(stringBuilder);
        System.out.println(tarnsformedString);

        char[] chars = tarnsformedString.toCharArray();
        System.out.println(chars);

        stringBuilder.deleteCharAt(0);
        System.out.println(stringBuilder);
        stringBuilder.append('h');
        System.out.println(stringBuilder);
    }
}
