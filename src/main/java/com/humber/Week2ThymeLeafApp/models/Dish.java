package com.humber.Week2ThymeLeafApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //used for fields and can also use @getterandsetter
@AllArgsConstructor
@NoArgsConstructor
@Builder 

//this dish model maps the table in the database
public class Dish {

    private int id;
    private String name;
    private String category;
    private Double price;
}


