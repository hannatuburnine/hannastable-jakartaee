package com.hannastable.dtos;

import com.hannastable.models.Client;

public class OrderDTO {

    private int id;
    private double price;


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
