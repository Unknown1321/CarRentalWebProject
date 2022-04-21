package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.SportCar;
import com.example.carrentalweb.Repository.SportRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SportService {

    @Autowired
    private SportRepo sportRepo;

    public List<SportCar> fetchAll(){
        return sportRepo.fetchAll();
    }
}
