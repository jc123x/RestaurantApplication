package com.humber.Week5RestaurantApp.repositories;

import com.humber.Week5RestaurantApp.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//repository interacts with database to perform operations
@Repository
public class DishRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //removed the static list

    //inserts new dish to database
    public void saveDish(Dish dish) {
        //placeholders for values which are then passed as arguments to jdbc template update method
        String query = "INSERT INTO dishes (name, category, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, dish.getName(), dish.getCategory(), dish.getPrice());
    }


    //retrieves all dishes from db
    public List<Dish> getAllDishes() {
        String query = "SELECT * FROM dishes";
        return jdbcTemplate.query(query, (rs, rowNum) ->
                Dish.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .category(rs.getString("category"))
                        .price(rs.getDouble("price"))
                        .build());
    }
}