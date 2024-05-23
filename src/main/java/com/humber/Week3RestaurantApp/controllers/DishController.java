package com.humber.Week3RestaurantApp.controllers;

import com.humber.Week3RestaurantApp.models.Dish;
import com.humber.Week3RestaurantApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")  //base url

public class DishController {

    //field injection - injecting service into controller

    @Autowired  //spring will automatically inject an instance of dishservice in this field
    private DishService dishService;

    //@Value("${restaurant.name}")
    @Value("Dine Divine")
    private String name;

    //home page
    @GetMapping("/home") //handles get requests
    public String home(Model model) {
        model.addAttribute("restaurantName", name);
        return "home";

    }

    //getAllDishes takes model object as parameter, adds attribute dishes with value obtained from dishservice.getAllDihes, returns menu template
    @GetMapping("/dishes")
    // public List<Dish> getAllDishes(){
    public String getAllDishes(Model model) {
        model.addAttribute("dishes", dishService.getAllDishes());
        //return dishService.getAllDishes();
        return "menu";
    }

    //open up add dish page
    //used getmapping which will make the webpage open up a form
    @GetMapping("/add-dish")
    public String addDish(Model model) {
        model.addAttribute("dish", new Dish());
        return "add-dish";
    }

    //save the dish
    //@{/restaurant/add-dish}
    @PostMapping("/add-dish")
    public String addDish(@ModelAttribute Dish dish, Model model) {
        //saving happening here in db
        //if you want to save, you would have to call dishservice  --> dishservice.saveDish(dish)


        if (dish.getPrice()>10){
            model.addAttribute("error",  "Price should be less than 10");
            return "add-dish";

        }
        model.addAttribute("dishes", dish);
        return "menu";

    }



}
