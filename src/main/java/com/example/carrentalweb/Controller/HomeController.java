package com.example.carrentalweb.Controller;

import com.example.carrentalweb.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
// hey brother
    @Autowired
    private CustomerService customerService;

//    @GetMapping("/")
//    public String getIndex(){
//        return "home/index";
//    }

    @GetMapping("/")
    public String getCustomers(Model model){
        model.addAttribute("customers",customerService.fetchAll());
        return "home/index";
    }
}
