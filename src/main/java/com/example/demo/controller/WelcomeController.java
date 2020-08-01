package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }
    
    @GetMapping("/addcart")
    public String addCart() {
     

        return "addcart"; //view
    }
    
    @GetMapping("/forklifts")
    public String forklifts() {
     

        return "forklifts"; //view
    }
    
    
    @GetMapping("/test")
    public String testt() {
     

        return "test"; //view
    }
    
    @GetMapping("/stripeform")
    public String stripeForm() {
     

        return "stripeform"; //view
    }
    
    @GetMapping("/placeorder")
    public String placeorder() {
     

        return "placeorder"; //view
    }
    
    @GetMapping("/ordersearch")
    public String ordersearch() {
     

        return "ordersearch"; //view
    }
    
    
    @GetMapping("/upload")
    public String uploadTheFile() {
     

        return "upload"; //view
    }
    
    @GetMapping("/register")
    public String register() {
     
        return "register"; //view
    }
    
    
    @GetMapping("/prasadcart")
    public String prasadCart() {
     

        return "prasadcart"; //view
    }


    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") 
			String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }
    
    @GetMapping("/testRequestParams")
    public String testRequestParams() {  

        return "jQueryRequestParams"; //view
    }
    
    
    @GetMapping("/testPathParams")
    public String testPathParams()
    {
     
        return "jQueryPathVariables"; //view
    }

}