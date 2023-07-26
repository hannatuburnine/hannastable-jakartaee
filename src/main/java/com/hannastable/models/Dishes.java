package com.hannastable.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "DISHES")
public class Dishes {

    @Id
    @Column(name = "DISHES_NAME")
    private String name;

    @Column(name = "INGREDIENTS")
    @OneToMany(mappedBy = "dishes")
    private ArrayList<Ingredients> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
