package org.java.learning.designpatterns.creational.factory.phone;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory osf = new OperatingSystemFactory();

        OS obj = osf.getInstance("");
        obj.specs();
    }
}
