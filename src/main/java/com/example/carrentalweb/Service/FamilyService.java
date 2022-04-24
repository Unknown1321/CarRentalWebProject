package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.FamilyCar;
import com.example.carrentalweb.Repository.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepo;

    public List<FamilyCar> fetchAll(){
        return familyRepo.fetchAll();
    }

    public void addNew (FamilyCar familyCar){
        familyRepo.addFamilyCar(familyCar);
    }
}
