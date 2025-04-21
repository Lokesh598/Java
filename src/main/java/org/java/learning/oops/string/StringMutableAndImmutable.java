package org.java.learning.oops.string;

public class StringMutableAndImmutable {


    public static void main(String[] args) {
        String str = "program";
        String strCopy = "program";

        System.out.println(str == strCopy);


        String strD = new String("Hello");

        String strDCopy = new String("Hello");
        System.out.println(strD);
        System.out.println(strD.equals(strDCopy));

        System.out.println(strD.replace('H', 'h'));
        System.out.println(str.replace('p', 'P'));
        str = str.replace('p', 'P');

        System.out.println(str);
        System.out.println(strD);

    }
}
