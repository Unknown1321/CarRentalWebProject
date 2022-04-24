package com.example.carrentalweb.Controller;

import com.example.carrentalweb.Model.Customer;
import com.example.carrentalweb.Model.FamilyCar;
import com.example.carrentalweb.Model.LuxuryCar;
import com.example.carrentalweb.Model.SportCar;
import com.example.carrentalweb.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String adminMain(){
        return "admin/adminMain";
    }//Admin Main menu

    @GetMapping("/admin/carsMenu")
    public String carsMenu(){
        return "/admin/carsMenu";
    }//Cars menu

    @GetMapping("/admin/viewCars")
    public String viewCars(Model model){
        List<FamilyCar> familyCars = familyService.fetchAll();
        model.addAttribute("familyCars", familyCars);
        return "/admin/viewCars";
    }//view cars only view

    @GetMapping("/admin/newCar")
    public String newCar (){
        return "/admin/newCar";
    }//Choose type

    @GetMapping("/admin/newFamily")
    public String newFamily(){
        return "/admin/newFamily";
    } //new family GET

    @PostMapping("/admin/newFamily")
        public String newFamily(@ModelAttribute FamilyCar familyCar){
        System.out.println("ENTER RIGTH METHOD");
            carService.addnew(familyCar);
            familyService.addNew(familyCar);
        System.out.println(familyCar);
            return "redirect:/";
    }// new family POST

    //new luxury GET
    @GetMapping("/admin/newLuxury")
    public String newLuxury(){
        return "/admin/newLuxury";
    }
    //new luxury POST
    @PostMapping("/admin/newLuxury")
    public String newLuxury(@ModelAttribute LuxuryCar luxuryCar){
        carService.addnew(luxuryCar);
        luxuryService.addNew(luxuryCar);
        return "redirect:/";
    }
    //new sport GET
    @GetMapping("/admin/newSport")
    public String newSport(){
        return "/admin/newSport";
    }
    //new sport POST
    @PostMapping("/admin/newSport")
    public String newSport (@ModelAttribute SportCar sportCar){
        carService.addnew(sportCar);
        sportService.addNew(sportCar);
        return "redirect:/";
    }


    @GetMapping("/admin/customer")
        public String customerPage(@ModelAttribute Customer customer, Model model){
            model.addAttribute("customers",customerService.fetchAll());
            return "admin/customer";
    }
}
