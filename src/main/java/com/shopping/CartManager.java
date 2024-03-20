package com.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartManager {
    private static CartManager instance;
    private List<Product> cartItems = new ArrayList<>();

    private CartManager() {}

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public boolean removeProduct(String productId) {
        return cartItems.removeIf(product -> Objects.equals(product.getId(), productId));
    }

    public void clearCart() {
        cartItems.clear();
    }

    public List<Product> getCartItems() {
        return new ArrayList<>(cartItems); // Return a copy to prevent direct modification
    }

    // Optionally, implement a method to calculate the total price of the cart
    public double getTotalPrice() {
        return cartItems.stream()
                        .mapToDouble(Product::getPrice)
                        .sum();
    }
}
