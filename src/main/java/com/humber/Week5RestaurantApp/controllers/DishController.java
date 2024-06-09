package com.humber.Week5RestaurantApp.controllers;

import com.humber.Week5RestaurantApp.models.Dish;
import com.humber.Week5RestaurantApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
public class DishController {

    private final DishService dishService;

    @Value("Dine Divine")
    private String name;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/home") //handles get requests to home
    public String home(Model model) {
        model.addAttribute("restaurantName", name);
        return "home";
    }

    @GetMapping("/dishes")  //retrieves dishes from dish service
    public String getAllDishes(Model model) {
        model.addAttribute("dishes", dishService.getAllDishes()); //list of dishes added to model
        return "menu";
    }

    @GetMapping("/add-dish")
    public String addDish(Model model) {
        model.addAttribute("dish", new Dish());  //adds new dish object to model
        return "add-dish";
    }

    @PostMapping("/add-dish")  //request to send data to server
    public String addDish(@ModelAttribute Dish dish, Model model) {
        try {
            dishService.addDish(dish); // Call the service method to add the dish
            return "redirect:/restaurant/dishes";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "add-dish";
        }
    }
}