package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Model.LuxuryCar;
import com.example.carrentalweb.Repository.LuxuryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuxuryService {

    @Autowired
    private LuxuryRepo luxuryRepo;

    public List<LuxuryCar> fetchAll(){
        return luxuryRepo.fetchAll();
    }

    public void addNew (LuxuryCar car){
        luxuryRepo.addLuxuryCar(car);
    }

    public void deleteCar(LuxuryCar luxuryCar) {
        luxuryRepo.deleteLuxuryCar(luxuryCar.getRegistrationNumber());
    }
}
