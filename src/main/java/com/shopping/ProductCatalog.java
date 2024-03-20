package com.shopping;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product1> products = new ArrayList<>();

    public void addProduct(Product1 product) {
        products.add(product);
    }

    public List<Product1> getProducts() { return products; }
}