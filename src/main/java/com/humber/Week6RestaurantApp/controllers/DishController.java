package com.humber.Week6RestaurantApp.controllers;

import com.humber.Week6RestaurantApp.models.Dish;
import com.humber.Week6RestaurantApp.services.DishService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/restaurant")
public class DishController {

    //field injection - injecting service into controller
    private final DishService dishService;

    @Value("${restaurant.name}")
    private String name;

    //constructor injection
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    //home page
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("restaurantName", name);
        return "home";
    }

    @GetMapping("/menu")
    public String getAllDishes(Model model, @RequestParam(required = false) String message,
                               @RequestParam(required = false) String searchedCategory,
                               @RequestParam(required = false) Double searchedPrice) {


        if(searchedCategory!=null && searchedPrice!=null){
            //return back the filtered dishes from the service layer
            List<Dish> filteredDishes = dishService.getFilteredDishes(searchedCategory, searchedPrice);
            model.addAttribute("dishes", filteredDishes.isEmpty()?dishService.getAllDishes() : filteredDishes);
            model.addAttribute("message", filteredDishes.isEmpty()? "Dish Not Found!" : "Dish Found!");
            return "menu";
        }

        model.addAttribute("dishes", dishService.getAllDishes());
        model.addAttribute("message", message);
        return "menu";
    }

    //open up add-dish page
    @GetMapping("/add-dish")
    public String addDish(Model model) {
        model.addAttribute("dish", new Dish());
        return "add-dish";
    }


    //save the dish
    @PostMapping("/add-dish")
    public String addDish(@ModelAttribute Dish dish, Model model) {

        //saving in db
        int statusCode = dishService.saveDish(dish);

        //1 for success, 0 for failure
        if(statusCode == 1){
            return "redirect:/restaurant/menu?message=Dish added successfully!";
        }

        model.addAttribute("error", "Price should be less than 15!");
        return "add-dish";
    }

    //delete a dish
    @GetMapping("/delete/{id}")
    public String deleteDish(@PathVariable int id){
        int deleteStatusCode = dishService.deleteDish(id);

        if(deleteStatusCode ==1){
            return "redirect:/restaurant/menu?message=Dish deleted successfully!";
        }


        return "redirect:/restaurant/menu?message=Dish to be deleted does not exist!";
    }

    //update a dish (open the update form)
    @GetMapping("/update/{id}")
    public String updateDish(Model model, @PathVariable int id){
        Optional<Dish> dishToUpdate = dishService.getDishById(id);
        model.addAttribute("dish", dishToUpdate.orElse(null));
        return "add-dish";
    }

    //update a dish
    @PostMapping("/update-dish")
    public String updateDish(@ModelAttribute Dish dish) {
        dishService.updateDish(dish);
        return "redirect:/restaurant/menu?message=Dish Updated Successfully!";
    }
}
