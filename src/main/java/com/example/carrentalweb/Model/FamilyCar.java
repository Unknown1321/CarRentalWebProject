package com.example.carrentalweb.Model;

public class FamilyCar extends Car {

    private boolean manual_gear;
    private boolean air_condition;
    private boolean cruise_control;
    private boolean seven_seats_or_more;

    public FamilyCar(){}


    public FamilyCar(String registrationNumber, String brand, String model, String registrationDate, int kmDriven, boolean manual_gear, boolean air_condition, boolean cruise_control, boolean seven_seats_or_more) {
        super(registrationNumber, brand, model, registrationDate, kmDriven);
        this.manual_gear = manual_gear;
        this.air_condition = air_condition;
        this.cruise_control = cruise_control;
        this.seven_seats_or_more = seven_seats_or_more;
    }

    public boolean isManual_gear() {
        return manual_gear;
    }

    public void setManual_gear(boolean manual_gear) {
        this.manual_gear = manual_gear;
    }

    public boolean isAir_condition() {
        return air_condition;
    }

    public void setAir_condition(boolean air_condition) {
        this.air_condition = air_condition;
    }

    public boolean isCruise_control() {
        return cruise_control;
    }

    public void setCruise_control(boolean cruise_control) {
        this.cruise_control = cruise_control;
    }

    public boolean isSeven_seats_or_more() {
        return seven_seats_or_more;
    }

    public void setSeven_seats_or_more(boolean seven_seats_or_more) {
        this.seven_seats_or_more = seven_seats_or_more;
    }
}
