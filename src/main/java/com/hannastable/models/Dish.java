package com.hannastable.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "DISHES")
public class Dish {

    @Column(name = "DISH_NAME")
    private String name;

    @Column(name = "DISH_PRICE")
    private double price;

    @OneToMany(mappedBy = "dish")
    private List<Ingredients> ingredients;

    @Id
    @Column(name = "DISH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
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
