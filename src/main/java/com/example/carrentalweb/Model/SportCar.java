package com.example.carrentalweb.Model;


public class SportCar extends Car {

    private boolean manualGear;
    private boolean over200HP;

    public SportCar(String registrationNumber, String brand, String model, String registrationDate,
                 int kmDriven, boolean manualGear, boolean over200HP) {
        super(registrationNumber, brand, model, registrationDate, kmDriven);
        this.manualGear = manualGear;
        this.over200HP = over200HP;
    }

    @Override
    public String toString() {
        return /*getClass().getSimpleName()+" car: "+super.toString()+*/
                String.format("| %-14s %-14s %-12s %-12s %-12d %-10b %-10b |",
                        getRegistrationNumber(), getBrand(), getModel(), getRegistrationDate(),
                        getKmDriven(), isManualGear(),isOver200HP());


    }
    public boolean isManualGear() {
        return manualGear;
    }

    public void setManualGear(boolean manualGear) {
        this.manualGear = manualGear;
    }

    public boolean isOver200HP() {
        return over200HP;
    }

    public void setOver200HP(boolean over200HP) {
        this.over200HP = over200HP;
    }
}
