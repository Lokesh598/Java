package org.java.learning.oops.abstractionbyinterface;

public class Interface {

    /**
     * achiving runtime polymorphism using interface
     */
}

interface Test {
    void method1();
    void method2();
    public static void method3() {
        System.out.println("method3");
    }
}

class TestClass implements Test {
    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    public boolean method4() {
        return true;
    }
}

class Output {
    public static void main(String[] args) {
        Test t = new TestClass();
        t.method1();
        t.method2();
        Test.method3();
        TestClass tc = new TestClass();
        tc.method4();
    }
}