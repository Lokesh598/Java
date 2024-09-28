package org.java.learning.com.designpatterns.factory;

import org.java.learning.com.designpatterns.factory.phone.Android;
import org.java.learning.com.designpatterns.factory.phone.OS;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory osf = new OperatingSystemFactory();

        OS obj = osf.getInstance("");
        obj.specs();
    }
}
