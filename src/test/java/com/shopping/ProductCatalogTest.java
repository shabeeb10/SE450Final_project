package com.shopping;
import com.shopping.Products.Electronics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogTest {

    private ProductCatalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new ProductCatalog();
    }

    @Test
    void testAddAndGetProducts() {
        Product product = new Electronics("1", "Laptop", 999.99);
        catalog.addProduct(product);
        assertFalse(catalog.getProducts().isEmpty(), "Catalog should not be empty after adding a product");
        assertEquals(1, catalog.getProducts().size(), "Catalog size should be 1 after adding one product");
        assertSame(product, catalog.getProducts().get(0), "The added product should be retrievable from the catalog");
    }
}

