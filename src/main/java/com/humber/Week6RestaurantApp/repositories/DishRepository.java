package com.humber.Week6RestaurantApp.repositories;

import com.humber.Week6RestaurantApp.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {


//    List<Dish> findByCategoryAndPrice(String searchedCategory, Double searchedPrice);

    //native query (custom method)
    @Query(value="select * from Dish where lower(category) = lower(?1) and price = ?2", nativeQuery = true)
    public List<Dish> findByCategoryAndPrice(String searchedCategory, Double searchedPrice);
}
