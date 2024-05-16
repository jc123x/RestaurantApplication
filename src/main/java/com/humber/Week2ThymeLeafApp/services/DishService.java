package com.humber.Week2ThymeLeafApp.services;

import com.humber.Week2ThymeLeafApp.models.Dish;
import com.humber.Week2ThymeLeafApp.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    //add a  method to get all dishes

    public List<Dish> getAllDishes(){
        return DishRepository.getDishes();
    }


}
