package com.shopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shopping.Products.Electronics;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {

    private CartManager cartManager;

    @BeforeEach
    void setUp() {
        cartManager = CartManager.getInstance();
        cartManager.clearCart(); // Ensure the cart is empty before each test
    }

    @Test
    void testAddProduct() {
        Product product = new Electronics("1", "Laptop", 999.99);
        cartManager.addProduct(product);
        assertEquals(1, cartManager.getCartItems().size(), "Cart size should increase by 1 after adding a product");
    }
}
