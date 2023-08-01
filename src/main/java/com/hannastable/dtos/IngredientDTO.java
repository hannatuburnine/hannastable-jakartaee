package com.hannastable.dtos;

public class IngredientDTO {

    private String ingredientName;
    private int expiringDate;
    private double batch;

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
