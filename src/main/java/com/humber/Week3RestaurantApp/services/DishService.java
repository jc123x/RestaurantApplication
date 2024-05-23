package com.humber.Week3RestaurantApp.services;

import com.humber.Week3RestaurantApp.models.Dish;
import com.humber.Week3RestaurantApp.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    //add a  method to get all dishes
//getAllDishes retrieves list of dishes from dishRepository and returns it
    public List<Dish> getAllDishes(){
        return DishRepository.getDishes();
    }
}
