package org.java.learning.oops.abstraction;

abstract class Animal {
    String name = "cat";
    abstract void returnAnimal();
    Animal() {
        System.out.println("Animal class called by super() method");
    }
    public void typesOfAnimal() {
        System.out.println("this is concrete method in abstract type class");
    }
}
class Cow extends Animal {
    protected int x = 0;
    Cow() {
        //what super do? super call constructor of base class.
        super();
    }
    void returnAnimal() {
        System.out.println("Cow"+ super.name);
        super.typesOfAnimal(); // super with methods
    }
}
class BabyCow extends Cow {
    void printBabyCow() {
        System.out.println("bachda");
    }
}
public class Example {
    public static void main(String[] args) {
        Integer x =Integer.valueOf("100");
        Boolean b = Boolean.valueOf("True");

        System.out.println(b);
        Cow cow = new Cow();
        cow.returnAnimal();
        cow.typesOfAnimal();
    }
}
