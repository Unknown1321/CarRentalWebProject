package com.example.carrentalweb.Controller;

import com.example.carrentalweb.Model.*;
import com.example.carrentalweb.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    CarService carService;
    @Autowired
    FamilyService familyService;
    @Autowired
    LuxuryService luxuryService;
    @Autowired
    SportService sportService;

    @Autowired
    CustomerService customerService;


    @GetMapping("/admin")
    public String adminMain() {
        return "admin/adminMain";
    }//Admin Main menu

    @GetMapping("/admin/carsMenu")
    public String carsMenu() {
        return "/admin/carsMenu";
    }//Cars menu

    //customers menu
    @GetMapping("/admin/customerMenu")
    public String customerMenu() {
        return "/admin/customerMenu";
    }

    @GetMapping("/admin/viewCars")
    public String viewCars(Model model) {
        List<FamilyCar> familyCars = familyService.fetchAll();
        List<LuxuryCar> luxuryCars = luxuryService.fetchAll();
        List<SportCar> sportCars = sportService.fetchAll();
        model.addAttribute("familyCars", familyCars);
        model.addAttribute("luxuryCars", luxuryCars);
        model.addAttribute("sportCars", sportCars);
        return "/admin/viewCars";
    }//view cars only view


   /* @GetMapping("/admin/updateCarReg/{id}")
    public String updateCar(@PathVariable("id") String id, Model model) {
        model.addAttribute("car", carService.findCar(id));
        model.addAttribute("familyCar", familyService.findFamily(id));
        return "/admin/updateCarReg";
    }//update GET


    @PostMapping("/admin/updateCarReg")
    public String updateCar(@ModelAttribute FamilyCar familyCar) {
        //carService.updateByReg(familyCar.getRegistrationNumber(), familyCar);
        System.out.println("Error in sending to carRepo update");
        familyService.updateFamily(familyCar.getRegistrationNumber(), familyCar);
        System.out.println("Error in sending to familyRepo update");
        return "redirect:/";
    }*/

    @GetMapping("/admin/update/car/{registration_number}")
    public String updateCar(@PathVariable("registration_number") String registrationNumber, Model model){
        model.addAttribute("updateFamilyCar", familyService.findFamily(registrationNumber));
        return "admin/updateCarReg";
    }

    @PostMapping("/updateCar")
    public String updateCars(@ModelAttribute FamilyCar familyCar){
        familyService.updateFamily(familyCar.getRegistrationNumber(), familyCar);
        return "redirect:/admin/carsMenu";
    }


    @GetMapping("/admin/newCar")
    public String newCar() {
        return "/admin/newCar";
    }//Choose type

    @GetMapping("/admin/newFamily")
    public String newFamily() {
        return "/admin/newFamily";
    } //new family GET

    @PostMapping("/admin/newFamily")
    public String newFamily(@ModelAttribute FamilyCar familyCar) {
        System.out.println("ENTER RIGHT METHOD");
        carService.addNew(familyCar);
        familyService.addNew(familyCar);
        System.out.println(familyCar);
        return "redirect:/";
    }// new family POST

    //new luxury GET
    @GetMapping("/admin/newLuxury")
    public String newLuxury() {
        return "/admin/newLuxury";
    }

    //new luxury POST
    @PostMapping("/admin/newLuxury")
    public String newLuxury(@ModelAttribute LuxuryCar luxuryCar) {
        carService.addNew(luxuryCar);
        luxuryService.addNew(luxuryCar);
        return "redirect:/";
    }

    //new sport GET
    @GetMapping("/admin/newSport")
    public String newSport() {
        return "/admin/newSport";
    }

    //new sport POST
    @PostMapping("/admin/newSport")
    public String newSport(@ModelAttribute SportCar sportCar) {
        carService.addNew(sportCar);
        sportService.addNew(sportCar);
        return "redirect:/";
    }

    // delete family GET
    @GetMapping("/admin/deleteFamilyCar")
    public String deleteFamily() {
        return "/admin/deleteFamily";
    }

    // delete luxury GET
    @GetMapping("/admin/deleteLuxuryCar")
    public String deleteLuxury() {
        return "/admin/deleteLuxury";
    }

    // delete sport GET
    @GetMapping("/admin/deleteSportCar")
    public String deleteSport() {
        return "/admin/deleteSport";
    }

    @GetMapping("admin/car-viewFamily/{registrationNumber}")
    public String viewCarFamily(@PathVariable("registrationNumber") String registrationNumber, Model model) {
        model.addAttribute("car", carService.findCar(registrationNumber));
        model.addAttribute("familyCar", familyService.findFamily(registrationNumber));
        return "admin/view-carFamily";
    }

    @GetMapping("admin/car-viewLuxury/{registrationNumber}")
    public String viewCarLuxury(@PathVariable("registrationNumber") String registrationNumber, Model model) {
        model.addAttribute("car", carService.findCar(registrationNumber));
        model.addAttribute("luxuryCar", luxuryService.findLuxury(registrationNumber));
        return "admin/view-carLuxury";
    }

    @GetMapping("admin/car-viewSport/{registrationNumber}")
    public String viewCarSport(@PathVariable("registrationNumber") String registrationNumber, Model model) {
        model.addAttribute("car", carService.findCar(registrationNumber));
        model.addAttribute("sportCar", sportService.findSport(registrationNumber));
        return "admin/view-carSport";
    }

    @GetMapping("/admin/car/{registrationNumber}")
    public String deleteCar(@PathVariable("registrationNumber") String registrationNumber) {
        carService.deleteCar(registrationNumber);
        familyService.deleteCar(registrationNumber);
        luxuryService.deleteCar(registrationNumber);
        sportService.deleteCar(registrationNumber);
        return "redirect:/admin/carsMenu";
    }



    @GetMapping("/admin/customer")
    public String customerPage(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers", customerService.fetchAll());
        return "admin/customer";
    }

    @GetMapping("admin/new-customer")
    public String newCustomer() {
        return "admin/new-customer";
    }

    @PostMapping("admin/new-customer")
    public String newCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:customerMenu";
    }

    @GetMapping("admin/customer/{driver_license_number}")
    public String deleteCustomer(@PathVariable("driver_license_number") String licenceNumber) {
        customerService.deleteCustomer(licenceNumber);
        return "redirect:/admin/customerMenu";
    }

    @GetMapping("admin/customer-view/{driver_license_number}")
    public String viewOne(@PathVariable("driver_license_number") String licenseNumber, Model model) {
        model.addAttribute("customer", customerService.getCustomerByLicenceNumber(licenseNumber));
        return "admin/view-customer";
    }

//    @GetMapping("/update/{driver_license_number}")
//    public String updateCustomer(@PathVariable("driver_license_number") String licenseNumber, Model model) {
//        model.addAttribute("customerUpdate", customerService.getCustomerByLicenceNumber(licenseNumber));
//        return "admin/update-customer";
//    }
//
//    @PostMapping("/updateCustomer")
//    public String editCustomer(@ModelAttribute("customerUpdate") Customer customer) {
//        customerService.updateCustomer(customer.getDriver_license_number(), customer);
//        return "redirect:admin/customerMenu";
//    }

    @GetMapping("/update/{driver_license_number}")
    public String update(@PathVariable("driver_license_number") String licenseNumber, Model model){
        model.addAttribute("onecustomer",customerService.getCustomerByLicenceNumber(licenseNumber));
        return "admin/update-customer";
    }
    @PostMapping("/updateCustomer")
    public String updatePerson(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getDriver_license_number(), customer);
        return "redirect:/admin/customerMenu";
    }


}
