package org.java.learning.designpatterns.creational.prototype;


public interface Prototype {
    Prototype clone();
}

class Circle implements Prototype {
    private int rad;
    private String color;
    public Circle(int r, String col) {
        this.rad = r;
        this.color = col;
    }

    @Override
    public Prototype clone() {
        return new Circle(this.rad, this.color);
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "rad=" + rad +
                ", color='" + color + '\'' +
                '}';
    }
}

class Rectangle implements Prototype {
    private int l;
    private int b;
    @Override
    public Prototype clone() {
        return new Rectangle();
    }

}

class PrototypePattern {
    public static void main(String[] args) {
        Circle c = new Circle(12, "red");

        Circle prototype = (Circle) c.clone();
        prototype.setColor("blue");
        Prototype s = c.clone();

        System.out.println(c);
        System.out.println(prototype);
    }
}
