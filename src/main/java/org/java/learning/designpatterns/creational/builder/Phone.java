package org.java.learning.designpatterns.creational.builder;

class Phone {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    private Phone(String os, int ram, String processor, double screenSize, int battery) {
        super();
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }


static class PhoneBuilder {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone() {
        return new Phone(os, ram, processor, screenSize, battery);
    }
}}

class Shop {
    public static void main(String[] args) {
        Phone p = new Phone.PhoneBuilder().setOs("Android").setRam(8).getPhone();
        System.out.println(p);
    }
}
