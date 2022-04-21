package com.example.carrentalweb.Model;

public class Customer {

    private String driver_license_number;
    private String driver_since_number;
    private String first_name;
    private String last_name;
    private int phone_number;
    private int mobile_number;
    private String email;
    private int zip_code;
    private String city;

    public Customer(String driver_license_number, String driver_since_number, String first_name, String last_name, int phone_number, int mobile_number, String email, int zip_code, String city) {
        this.driver_license_number = driver_license_number;
        this.driver_since_number = driver_since_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.mobile_number = mobile_number;
        this.email = email;
        this.zip_code = zip_code;
        this.city = city;
    }

    public Customer() {
    }

    public String getDriver_license_number() {
        return driver_license_number;
    }

    public void setDriver_license_number(String driver_license_number) {
        this.driver_license_number = driver_license_number;
    }

    public String getDriver_since_number() {
        return driver_since_number;
    }

    public void setDriver_since_number(String driver_since_number) {
        this.driver_since_number = driver_since_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
