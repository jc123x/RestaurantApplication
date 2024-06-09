package com.humber.Week5RestaurantApp.services;

import com.humber.Week5RestaurantApp.models.Dish;
import com.humber.Week5RestaurantApp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public void addDish(Dish dish) {
        if (dish.getPrice() > 20) {  //business logic to check price of dish
            throw new IllegalArgumentException("Price should be less than $20");
        }

        dishRepository.saveDish(dish);
    }

    //retrieves all dishes
    public List<Dish> getAllDishes() {
        return dishRepository.getAllDishes();
    }
}