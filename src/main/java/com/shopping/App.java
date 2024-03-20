package com.shopping;
import com.shopping.Products.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final UserAuthenticator authenticator = new UserAuthenticator();
    private static final CartManager cartManager = CartManager.getInstance();
    @SuppressWarnings("unused")
    private static final Logger logger = new Logger();
    private static final List<Product> availableProducts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeProducts();
        System.out.println("Welcome to the Shopping System");

        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register a new user");
            System.out.println("2. Login");
            System.out.println("3. View available products");
            System.out.println("4. Add products to the cart");
            System.out.println("5. Remove a product from the cart");
            System.out.println("6. View cart and checkout");
            System.out.println("7. Search products");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    displayAvailableProducts();
                    break;
                case 4:
                    addProductsToCart();
                    break;
                case 5:
                    removeProductFromCart();
                    break;
                case 6:
                    checkoutCart();
                    break;
                case 7:
                    searchProducts();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        System.out.println("Thank you for using the Shopping System. Goodbye!");
    }

    private static void registerUser() {
        System.out.println("\nRegister a new user");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (authenticator.register(username, password)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. User might already exist.");
        }
    }

    private static void loginUser() {
        System.out.println("\nAuthenticate");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (!authenticator.login(username, password)) {
            System.out.println("Authentication failed. Check your credentials.");
        } else {
            System.out.println("Authentication successful.");
        }
    }

    private static void displayAvailableProducts() {
        System.out.println("\nAvailable Products (showing up to 10):");
        for (int i = 0; i < Math.min(availableProducts.size(), 10); i++) {
            Product p = availableProducts.get(i);
            System.out.printf("%d: %s - %s - $%.2f\n", i + 1, p.getId(), p.getDescription(), p.getPrice());
        }
    }

    private static void searchProducts() {
        System.out.print("\nEnter product description to search: ");
        String description = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Product product : availableProducts) {
            if (product.getDescription().toLowerCase().contains(description)) {
                System.out.printf("%s - %s - $%.2f\n", product.getId(), product.getDescription(), product.getPrice());
                found = true;
                break; // Remove this line if you want to find all matches instead of just the first
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }


    private static void addProductsToCart() {
        System.out.println("Enter product numbers to add to the cart (comma separated): ");
        String[] productIndexes = scanner.nextLine().split(",");
        for (String index : productIndexes) {
            try {
                int idx = Integer.parseInt(index.trim()) - 1;
                cartManager.addProduct( availableProducts.get(idx));
                System.out.println("Added: " + availableProducts.get(idx).getDescription());
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Invalid product number: " + index);
            }
        }
    }

    private static void removeProductFromCart() {
        System.out.println("\nEnter product ID to remove from the cart: ");
        String productId = scanner.nextLine();
        if (cartManager.removeProduct(productId)) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    private static void checkoutCart() {
        System.out.println("\nCart contents:");
        cartManager.getCartItems().forEach(product ->
                System.out.println(product.getDescription() + " - $" + product.getPrice())
        );
        System.out.println("Total Price: $" + cartManager.getTotalPrice());
        System.out.println("\nItem Purchased...");
        cartManager.clearCart();
        System.out.println("Cart cleared.");
    }

    private static void initializeProducts() {
        // Books
        for (int i = 1; i <= 10; i++) {
            availableProducts.add(new Books("B" + i, "Book Title " + i, 10.00 + i));
        }

        // Electronics
        for (int i = 1; i <= 10; i++) {
            availableProducts.add(new Electronics("E" + i, "Electronic Item " + i, 100.00 * i));
        }

        // Clothing
        for (int i = 1; i <= 10; i++) {
            availableProducts.add(new Clothing("C" + i, "Clothing Item " + i, 20.00 + i));
        }

        // Food Items
        for (int i = 1; i <= 10; i++) {
            availableProducts.add(new FoodItems("F" + i, "Food Item " + i, 5.00 + i * 0.5));
        }

        // Toys
        for (int i = 1; i <= 10; i++) {
            availableProducts.add(new Toys("T" + i, "Toy " + i, 15.00 + i));
        }

        // Home Appliances
        for (int i = 1; i <= 10; i++) {
            availableProducts.add(new HomeAppliances("H" + i, "Home Appliance " + i, 50.00 * i));
        }
    }

}


