package org.java.learning.oops.abstraction;

abstract class
Shape {
    public abstract void getArea();
}

class Circle extends Shape {
    public void getArea() {
        int radius = 4;
        double area = 3.14*radius*radius;
        System.out.println("Area of circle: "+area);
    }
}
class Rectangle extends Shape {
    public void getArea() {
        int l = 3, b = 2;
        double area = l*b;
        System.out.println("Area of Rectangle: " + area);
    }
}
public class Geometry {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        r.getArea();
        c.getArea();
    }
}
