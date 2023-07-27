package com.hannastable.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table(name = "INGREDIENTS")
@Entity
public class Ingredients {

    @Id
    @Column(name = "INGREDIENT_NAME")
    private String ingredientName;

    @Column(name = "EXPIRING_DATE")
    private int expiringDate;

    @Column(name = "BATCH")
    private double batch;

    @JoinColumn(name = "DISHES_FK")
    @ManyToOne
    @JsonIgnore
    private Dishes dish;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(int expiringDate) {
        this.expiringDate = expiringDate;
    }

    public double getBatch() {
        return batch;
    }

    public void setBatch(double batch) {
        this.batch = batch;
    }
}
