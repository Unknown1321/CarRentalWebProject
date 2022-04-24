package com.example.carrentalweb.Controller;

import com.example.carrentalweb.Model.Customer;
import com.example.carrentalweb.Model.FamilyCar;
import com.example.carrentalweb.Service.CarService;
import com.example.carrentalweb.Service.CustomerService;
import com.example.carrentalweb.Service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    CarService carService;
    @Autowired
    FamilyService familyService;

    @Autowired
    CustomerService customerService;


    @GetMapping("/admin")
    public String adminMain(){
        return "admin/adminMain";
    }//Admin Main menu

    @GetMapping("/admin/carsMenu")
    public String carsMenu(){
        return "/admin/carsMenu";
    }//Cars menu

    @GetMapping("/admin/viewCars")
    public String viewCars(){
        return "/admin/carsMenu";
    }//view cars only view

    @GetMapping("/admin/newCar")
    public String newCar (){
        return "/admin/newCar";
    }//Choose type

    @GetMapping("/admin/newFamily")
    public String newFamily(){
        return "/admin/newFamily";
    } //new family

    @PostMapping("/admin/newFamily")
        public String newFamily(@ModelAttribute FamilyCar familyCar){
        System.out.println("ENTER RIGTH METHOD");
            carService.addnew(familyCar);
            familyService.addNew(familyCar);
        System.out.println(familyCar);
            return "redirect:/";
    }// new family


    @GetMapping("/admin/customer")
        public String customerPage(@ModelAttribute Customer customer, Model model){
            model.addAttribute("customers",customerService.fetchAll());
            return "admin/customer";
    }
}
