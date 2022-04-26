package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.LuxuryCar;
import com.example.carrentalweb.Model.SportCar;
import com.example.carrentalweb.Repository.SportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    @Autowired
    private SportRepo sportRepo;

    public List<SportCar> fetchAll(){
        return sportRepo.fetchAll();
    }

    public void addNew(SportCar sportCar){
        sportRepo.addSportCar(sportCar);
    }

    public SportCar findSport(String regNum){
        return sportRepo.getSportCarByRegistrationNumber(regNum);
    }

    public void deleteCar(String registrationNumber) {
        sportRepo.deleteSportCar(registrationNumber);
    }
}
