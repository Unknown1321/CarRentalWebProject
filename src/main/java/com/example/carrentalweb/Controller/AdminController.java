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
        model.addAttribute("familyCars", familyCars);
        return "/admin/viewCars";
    }//view cars only view

    @GetMapping("/admin/updateCar")
    public String updateCar(Model model) {
        List<FamilyCar> familyCars = familyService.fetchAll();
        model.addAttribute("familyCars", familyCars);
        return "/admin/updateCar";
    }//view cars only for updating method


    @GetMapping("/admin/updateCarReg/{id}")
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

    @GetMapping("/update/{driver_license_number}")
    public String updateCustomer(@PathVariable("driver_license_number") String licenseNumber, Model model) {
        model.addAttribute("customerUpdate", customerService.getCustomerByLicenceNumber(licenseNumber));
        return "admin/update-customer";
    }

    @PostMapping("/updateCustomer")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getDriver_license_number(), customer);
        return "redirect:admin/customerMenu";
    }


}
