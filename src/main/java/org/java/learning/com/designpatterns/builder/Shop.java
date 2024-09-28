package org.java.learning.com.designpatterns.builder;

public class Shop {
    public static void main(String[] args) {
        Phone p = new PhoneBuilder().setOs("Android").setRam(8).getPhone();
        System.out.println(p);
    }
}
