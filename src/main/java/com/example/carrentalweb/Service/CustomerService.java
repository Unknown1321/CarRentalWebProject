package com.example.carrentalweb.Service;

import com.example.carrentalweb.Model.Customer;
import com.example.carrentalweb.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;



    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

    public void addCustomer(Customer customer) {
        customerRepo.addCustomer(customer);
    }

    public Customer getCustomerByLicenceNumber(String licenceNumber) {
        return customerRepo.getCustomerByLicenceNumber(licenceNumber);
    }

    public void updateCustomer(String driver_license_number, Customer customer) {
        customerRepo.updateCustomer(driver_license_number,customer);
    }

    public void deleteCustomer(String licenceNumber) {
        customerRepo.deleteCustomer(licenceNumber);
    }
}
