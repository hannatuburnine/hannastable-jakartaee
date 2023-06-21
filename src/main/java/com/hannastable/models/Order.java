package com.hannastable.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Column(name = "ORDER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ORDER_PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(name = "CLIENT_FK")
    private Client client;

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
