package org.java.learning.oops.abstraction;

class Vehicle implements Interface{
    int tyre;
    int colur;

    public static void main(String[] args) {
//        Car car = new Car();
//        int numberOfWheels = 4;
//        car.vehicleType(numberOfWheels);



    }
    Vehicle(){

    }
    Vehicle(int t,int colur){
        this.tyre = t;
        this.colur = colur;
    }
    @Override
    public String vehicleType(int numberOfWheels) {

        if (numberOfWheels == 4)
            System.out.println("Its a Car!!");

        if (numberOfWheels == 6)
            return " It can be a bus or a mini truck";
        return "Unable to find Vehicle type";
    }

    @Override
    public void start() {
        System.out.println("start");
    }

}
