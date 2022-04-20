package com.example.carrentalweb.Model;

public class Customer {

    private String driverLicenseNumber;
    private String driverSinceNumber;
    private String name;
    private String lastName;
    private int zip;
    private String city;
    private int phone;
    private int mobilePhone;
    private String email;


    public Customer(String driverLicenseNumber, String driverSinceNumber, String name, String lastName,
                    int zip, String city, int phone, int mobilePhone, String email) {

        this.name = name;
        this.lastName = lastName;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverSinceNumber = driverSinceNumber;
    }

    public Customer() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(int mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getDriverSinceNumber() {
        return driverSinceNumber;
    }

}
