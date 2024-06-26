package com.humber.Week6RestaurantApp.services;

import com.humber.Week6RestaurantApp.models.Dish;
import com.humber.Week6RestaurantApp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    //field injection
//    @Autowired
//    private DishRepository dishRepository;

    private final DishRepository dishRepository;

    //constructor injection
    @Autowired
    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    // get all dishes
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    //save a dish
    public int saveDish(Dish dish){
        if(dish.getPrice() < 15){
            dishRepository.save(dish);
            return 1;
        }
        return 0;
    }

    //get filtered dishes
    public List<Dish> getFilteredDishes(String searchedCategory, Double searchedPrice) {
        return dishRepository.findByCategoryAndPrice(searchedCategory, searchedPrice);
    }

    //delete a dish
    public int deleteDish(int id){
        //check if the record exists and then only perform the delete operation
        if(dishRepository.existsById(id)){
            dishRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    //update a dish
    public void updateDish(Dish dish){
        dishRepository.save(dish);
    }

    //get a dish by id
    public Optional<Dish> getDishById(int id){
        return dishRepository.findById(id);
    }
}
