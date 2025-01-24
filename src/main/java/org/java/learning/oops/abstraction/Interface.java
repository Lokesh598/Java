package org.java.learning.oops.abstraction;


import java.util.Scanner;

/**
 * In java, all methods in an interface are implicitly public and abstract
 * there for we do not need to declare them as public or abstract
 */
public interface Interface {
    String vehicleType(int numberOfWheels);
    void start();
}

//inheritance, vehicle is a parent class, having vehicle type method
class Car extends Vehicle{
    int hpower;
    Car(int hpower,int tyre,int colur){
        super();
        this.hpower = hpower;
    }

    @Override
    public String vehicleType (int numberOfWheels) {
return  "";
    }

    public static void main(String[] args) {
//        Vehicle vehicle = new Vehicle();
//        vehicle.vehicleType(4);
    }
}

class Bus {
    public static void main(String[] args) {
//        Vehicle vehicle = new Vehicle();
//        System.out.println(vehicle.vehicleType(6));
    }
}

class VehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfWheels = sc.nextInt();
        System.out.println(numberOfWheels);
//
//        switch (Object) {
//
//        }

    }
}


