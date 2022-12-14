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

    public void addNew(FamilyCar familyCar){
        familyRepo.addFamilyCar(familyCar);
    }
    public FamilyCar findFamily(String regNum){
        return familyRepo.getFamilyCarByRegistrationNumber(regNum);
    }
    public void updateFamily (String reg, FamilyCar familyCar) {
        familyRepo.updateFamilyCar(reg, familyCar);
    }

    public void deleteCar(String registrationNumber) {
        familyRepo.deleteFamilyCar(registrationNumber);
    }
}
