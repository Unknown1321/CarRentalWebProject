package com.example.carrentalweb.Service;


import com.example.carrentalweb.Model.Car;
import com.example.carrentalweb.Model.Customer;
import com.example.carrentalweb.Model.Rental;
import com.example.carrentalweb.Repository.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepo rentalRepo;

    public void addRental(Rental rental){
        rentalRepo.addRental(rental);
    }
    public Rental getRentalByRentalId(int rentalId) {
        return rentalRepo.getRentalByRentalId(rentalId);
    }

    public List<Rental> fetchAll() {
       return rentalRepo.fetchAll();
    }
}
