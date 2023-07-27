package com.hannastable.dtos;

import java.util.ArrayList;

public class DishesDTO {

    private String name;
    private ArrayList<IngredientsDTO> ingredients = new ArrayList<>();
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
