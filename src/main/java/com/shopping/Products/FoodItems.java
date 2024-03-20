package com.shopping.Products;

import com.shopping.Product;

public class FoodItems implements Product {
    private String id;
    private String description;
    private double price;

    public FoodItems(String id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }
}

