package org.java.learning.model;

public class Student {
    private String name;
    private String standard;
    private int rollNumber;
    private String fatherName;
    private String contactNumber;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student() {

    }
    public Student(String name, String standard, int rollNumber, String fatherName, String contactNumber, Address address) {
        this.name = name;
        this.standard = standard;
        this.rollNumber = rollNumber;
        this.fatherName = fatherName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", rollNumber=" + rollNumber +
                ", fatherName='" + fatherName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
