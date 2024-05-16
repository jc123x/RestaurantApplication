package com.humber.Week2ThymeLeafApp.controllers;

import com.humber.Week2ThymeLeafApp.models.Dish;
import com.humber.Week2ThymeLeafApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/restaurant")

public class DishController {

    //field injection - injecting service into controller


    @Autowired
    private DishService dishService;

    //@Value("${restaurant.name}")
    @Value("Shawarma Palace")
    private String name;

    //home page
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("restaurantName", name);
        return "home";
       // return name;

    }

    @GetMapping("/dishes")
   // public List<Dish> getAllDishes(){
    public String getAllDishes(Model model){
        model.addAttribute("dishes", dishService.getAllDishes());
        //return dishService.getAllDishes();
        return "menu";
    }


}
