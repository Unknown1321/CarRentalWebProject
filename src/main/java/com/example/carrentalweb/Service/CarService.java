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

    public void addnew (Car car){
        carRepo.addCar(car);

    }
}
