package org.java.learning.com.designpatterns.factory;

import org.java.learning.com.designpatterns.factory.phone.Android;
import org.java.learning.com.designpatterns.factory.phone.IOS;
import org.java.learning.com.designpatterns.factory.phone.OS;
import org.java.learning.com.designpatterns.factory.phone.Window;

public class OperatingSystemFactory {
    public OS getInstance(String str) {
        if (str.equals("Open")) return new Android();
        else if (str.equals("Closed")) return new IOS();
        else return new Window();
    }
}
