package org.java.learning.oops.abstraction;

abstract class Company {
    abstract void printInfo();
}
class Google extends Company {
    @Override
    void printInfo() {
        String name = "Google";
        String center = "India";
        float revenue = 300000.2F;

        System.out.println("Info: "+"{"+"name = "+ name+" center = "+ center+" revenue = "+ revenue+"}");
    }
}

class Driver {
    public static void main(String[] args) {
        Google google = new Google();
        google.printInfo();
    }
}
