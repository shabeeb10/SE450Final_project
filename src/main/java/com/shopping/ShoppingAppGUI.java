package com.shopping;// Imports required for the GUI components
import com.shopping.Products.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

// Additional imports as required for your specific implementation
// Simulated product class
class Product1 {
    private String id;
    private String description;
    private double price;

    public Product1(String id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - $%.2f", id, description, price);
    }
}

// In ShoppingAppGUI constructor, after initializing the UI:
//initializeProducts(); // This should populate availableProducts with Product instances.

public class ShoppingAppGUI extends JFrame {
    // Reference to the main panel and card layout to switch views
    private JPanel mainPanel;
    private CardLayout cardLayout;

    // UserAuthenticator is assumed to be a class that you have defined for user authentication
    private UserAuthenticator authenticator = new UserAuthenticator();
    // CartManager is assumed to manage shopping cart functionalities
    private CartManager cartManager = CartManager.getInstance();

    public ShoppingAppGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Shopping System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adding different panels to the main panel
        mainPanel.add(createMainMenuPanel(), "MainMenu");
        mainPanel.add(createRegisterPanel(), "Register");
        mainPanel.add(createLoginPanel(), "Login");
        // Further panels for product viewing, cart management etc. would go here

        getContentPane().add(mainPanel);
        cardLayout.show(mainPanel, "MainMenu"); // Show the main menu by default
        // In ShoppingAppGUI's initializeUI method, add panels for product viewing and searching:
        mainPanel.add(createProductPanel(), "ViewProducts");
        mainPanel.add(createSearchPanel(), "SearchProducts");

    }

    // Create the Main Menu panel
    private JPanel createMainMenuPanel() {
        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnRegister = new JButton("Register");
        JButton btnLogin = new JButton("Login");
        JButton btnExit = new JButton("Exit");

        btnRegister.addActionListener(e -> cardLayout.show(mainPanel, "Register"));
        btnLogin.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        btnExit.addActionListener(e -> System.exit(0));

        JButton viewProductsButton = new JButton("View Products");
        viewProductsButton.addActionListener(e -> cardLayout.show(mainPanel, "ViewProducts"));
        menuPanel.add(viewProductsButton);

        JButton searchProductsButton = new JButton("Search Products");
        searchProductsButton.addActionListener(e -> cardLayout.show(mainPanel, "SearchProducts"));
        menuPanel.add(searchProductsButton);


        menuPanel.add(new JLabel("Main Menu", SwingConstants.CENTER));
        menuPanel.add(btnRegister);
        menuPanel.add(btnLogin);
        menuPanel.add(btnExit);


        return menuPanel;
    }

    // Create the Register panel
    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(0, 1, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Menu");

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticator.register(username, password)) {
                JOptionPane.showMessageDialog(this, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "Login");
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        registerPanel.add(new JLabel("Username:"));
        registerPanel.add(usernameField);
        registerPanel.add(new JLabel("Password:"));
        registerPanel.add(passwordField);
        registerPanel.add(registerButton);
        registerPanel.add(backButton);

        return registerPanel;
    }

    // Create the Login panel
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back to Menu");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticator.login(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to next view or functionality as needed
            } else {
                JOptionPane.showMessageDialog(this, "Login failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(backButton);

        return loginPanel;
    }

    // Adding to ShoppingAppGUI class:
    private static final List<Product> availableProducts = new ArrayList<>();
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


    private JPanel createProductPanel() {
        JPanel productPanel = new JPanel(new BorderLayout());
        JTextArea productArea = new JTextArea(20, 40);
        productArea.setEditable(false);

        // Display first 10 products or fewer
        availableProducts.stream().limit(10).forEach(product -> productArea.append(product.toString() + "\n"));

        productPanel.add(new JScrollPane(productArea), BorderLayout.CENTER);
        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        productPanel.add(backButton, BorderLayout.PAGE_END);

        return productPanel;
    }

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField(20);
        JTextArea searchResultsArea = new JTextArea(20, 40);
        searchResultsArea.setEditable(false);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().toLowerCase();
            searchResultsArea.setText(""); // Clear previous results
            availableProducts.stream()
                    .filter(product -> product.getDescription().toLowerCase().contains(searchText))
                    .forEach(product -> searchResultsArea.append(product.toString() + "\n"));
        });

        searchPanel.add(searchField, BorderLayout.PAGE_START);
        searchPanel.add(new JScrollPane(searchResultsArea), BorderLayout.CENTER);
        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        searchPanel.add(backButton, BorderLayout.PAGE_END);

        return searchPanel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingAppGUI app = new ShoppingAppGUI();
            app.setVisible(true);
        });
    }
}
