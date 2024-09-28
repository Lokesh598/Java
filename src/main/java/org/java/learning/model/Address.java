package org.java.learning.model;

public class Address {
    private int houseNumber;
    private String houseName;
    private String colonyName;
    private String city;
    private String district;
    private int postalCode;

    public Address(int houseNumber, String houseName, String colonyName, String city, String district, int postalCode) {
        this.houseNumber = houseNumber;
        this.houseName = houseName;
        this.colonyName = colonyName;
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getColonyName() {
        return colonyName;
    }

    public void setColonyName(String colonyName) {
        this.colonyName = colonyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", houseName='" + houseName + '\'' +
                ", colonyName='" + colonyName + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
