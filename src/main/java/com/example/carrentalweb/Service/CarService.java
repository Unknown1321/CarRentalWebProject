package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Model.FamilyCar;
import com.example.carrentalweb.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<Car> fetchAll(){
        return carRepo.fetchAll();
    }

    public void addNew(Car car){
        carRepo.addCar(car);

    }

    public Car findCar(String regNum){
        return carRepo.getCarByRegistrationNumber(regNum);
    }

    public void updateByReg (String reg, Car car){
        carRepo.updateCar(reg, car);
    }

public void deleteCar (String registrationNumber){
    carRepo.deleteCar(registrationNumber);}
}
