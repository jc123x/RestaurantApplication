package com.humber.Week2ThymeLeafApp.repositories;

import com.humber.Week2ThymeLeafApp.models.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {
    private static List<Dish> dishes = new ArrayList<Dish>();

    static{
        //dishes.add(new Dish(1, "Chicken", "Chicken", 1.99)); ---this does the same thing as the one below

        //this builder package is used since it displays the name of the fields
        dishes.add(
                Dish.builder().id(1).name("burger").category("american").price(9.0)
                        .build()
        );
        dishes.add(
                Dish.builder().id(2).name("ramen").category("japanese").price(4.0)
                        .build()
        );
        dishes.add(
                Dish.builder().id(3).name("pasta").category("italian").price(3.0)
                        .build()
        );
    }
    public static List<Dish> getDishes() {
        return dishes;
    }
}
