package com.shopping;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void testCreateProduct() {
        assertThrows(IllegalArgumentException.class, () -> ProductFactory.createProduct("unknown", "1", "Unknown Product", 0.0), "Creating a product with an unknown type should throw an exception");

        Product electronics = ProductFactory.createProduct("electronics", "1", "Laptop", 999.99);
        assertNotNull(electronics, "Electronics product creation should not return null");
        assertEquals("Laptop", electronics.getDescription(), "Electronics product should have the correct description");
    }
}
