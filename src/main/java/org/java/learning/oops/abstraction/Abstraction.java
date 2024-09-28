package org.java.learning.oops.abstraction;

public class Abstraction {
}

abstract class Super {
    public Super() {
        System.out.println("Super Constructor");
    }
    public void method1 () {
        System.out.println("Super Method1");
    }
    public abstract void method2();
}
//inherit the properties of Super class

class Sub extends Super {
    @Override
    public void method2() {
        System.out.println("Sub Method2");
    }
}

class Putput {
    public static void main(String[] args) {
//        Super s = new Super(); // Compilation Error: Cannot instantiate the type Super
        Sub s = new Sub();
        s.method1();
        s.method2();
        Super aSuper = new Sub(); // Upcasting or reference of Super class and object of Sub class
        aSuper.method1();
        aSuper.method2();
    }
}
