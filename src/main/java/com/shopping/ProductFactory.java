package com.shopping;

import com.shopping.Products.*;

public class ProductFactory {
    public static Product createProduct(String type, String id, String description, double price) {
        switch (type.toLowerCase()) {
            case "electronics":
                return new Electronics(id, description, price);
            case "clothing":
                return new Clothing(id, description, price);
            case "books":
                return new Books(id, description, price);
            case "toys":
                return new Toys(id, description, price);
            case "homeappliances":
                return new HomeAppliances(id, description, price);
            case "fooditems":
                return new FoodItems(id, description, price);
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}

