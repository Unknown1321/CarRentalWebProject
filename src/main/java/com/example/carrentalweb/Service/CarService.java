package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<Car> fetchAll(){
        return carRepo.fetchAll();
    }
}
