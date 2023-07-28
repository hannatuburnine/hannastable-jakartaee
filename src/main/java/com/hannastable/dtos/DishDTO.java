package com.hannastable.dtos;

import java.util.ArrayList;
import java.util.List;

public class DishDTO {

    private String name;
    private List<IngredientsDTO> ingredients = new ArrayList<>();
    private int id;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
