package org.java.learning.oops.encapsulation;

public class Encapsulation {


    /**
     * instanceOf operator, is used to check whether the object is instance of specific claas or subclass
     * it is particularly useful for checking object types, before casting helping to avoid classCastException.
     *
     *
     */
    static class InstanceOf {


        public static void main(String[] args) {
            InstanceOf instance = new InstanceOf();

            if (instance instanceof InstanceOf) {
                System.out.println("insetance is an instance of InstanceOf class");
            }
        }
    }
}
