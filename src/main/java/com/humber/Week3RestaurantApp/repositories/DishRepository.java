package com.humber.Week3RestaurantApp.repositories;

import com.humber.Week3RestaurantApp.models.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//imports the dish model
//provides access to dish data
@Repository
public class DishRepository {
    private static List<Dish> dishes = new ArrayList<Dish>();

    static{
        //dishes.add(new Dish(1, "Chicken", "Chicken", 1.99)); ---this does the same thing as the one below

        //this builder package is used since it displays the name of the fields
        dishes.add(
                Dish.builder().id(1).name("Lobster Ravioli").category("Italian").price(9.0)
                        .build()
        );
        dishes.add(
                Dish.builder().id(2).name("Paella").category("Spanish").price(4.0)
                        .build()
        );
        dishes.add(
                Dish.builder().id(3).name("Moussaka").category("Greek").price(3.0)
                        .build()
        );

        dishes.add(
                Dish.builder().id(4).name("Ramen").category("Japanese").price(3.0)
                        .build()
        );

        dishes.add(
                Dish.builder().id(5).name("Pad Thai").category("Thai").price(30.0)
                        .build()
        );
    }
    public static List<Dish> getDishes() {
        return dishes;
    }
}
