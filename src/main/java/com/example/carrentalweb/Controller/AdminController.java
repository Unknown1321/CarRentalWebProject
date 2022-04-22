package com.example.carrentalweb.Controller;

import com.example.carrentalweb.Model.FamilyCar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminMain(){
        return "admin/adminMain";
    }

    @GetMapping("/admin/view")
    public String viewCars(){
        return "/admin/carsMenu";
    }

    @GetMapping("/admin/newCar")
    public String newCar (){
        return "/admin/newCar";
    }

    @GetMapping("/admin/newFamily")
    public String newFamily(){
        return "/admin/newFamily";
    }

    @PostMapping("/admin/newFamily")
        public String newFamily(@ModelAttribute FamilyCar familyCar){
            return "redirect:/admin";

    }

}
