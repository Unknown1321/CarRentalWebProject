package com.example.carrentalweb.Model;

public class FamilyCar extends Car {

    private boolean manualGear;
    private boolean airCondition;
    private boolean cruiseControl;
    private boolean sevenSeatsOrMore;
    // commit

    public FamilyCar() {
    }

    public FamilyCar(String brand, String model, String registration_number, String registration_date, int km_driven, boolean manualGear, boolean airCondition, boolean cruiseControl, boolean sevenSeatsOrMore) {
        super(registration_number, brand, model, registration_date, km_driven);
        this.manualGear = manualGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
        this.sevenSeatsOrMore = sevenSeatsOrMore;
    }

    public boolean isManualGear() {
        return manualGear;
    }

    public void setManualGear(boolean manualGear) {
        this.manualGear = manualGear;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public boolean isSevenSeatsOrMore() {
        return sevenSeatsOrMore;
    }

    public void setSevenSeatsOrMore(boolean sevenSeatsOrMore) {
        this.sevenSeatsOrMore = sevenSeatsOrMore;
    }
}