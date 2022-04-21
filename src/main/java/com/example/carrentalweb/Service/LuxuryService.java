package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.LuxuryCar;
import com.example.carrentalweb.Repository.LuxuryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LuxuryService {

    @Autowired
    private LuxuryRepo luxuryRepo;

    public List<LuxuryCar> fetchAll(){
        return luxuryRepo.fetchAll();
    }
}
