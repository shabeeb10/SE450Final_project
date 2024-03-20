# Shopping System

## Overview
The Shopping System is a Java-based application designed to simulate an online shopping environment. It supports functionalities such as user authentication, product management, shopping cart operations, and payment processing. The system is built with modularity in mind, making it easy to extend or modify components as needed.

## Features
- User registration and login.
- Product browsing with a variety of product categories.
- Adding and removing products from a shopping cart.
- Checking out the cart with a simple payment processing simulation.
- Extensible design for adding new product types or authentication methods.

## Getting Started

### Prerequisites
- Java JDK 11 or newer
- Any IDE that supports Java (IntelliJ IDEA, Eclipse, VS Code with Java extension)

### Installation
1. Clone the repository to your local machine.
2. Open the project in your IDE.
3. Ensure your IDE is configured to use the correct JDK version.
4. Build the project to resolve dependencies.

### Running the Application
Run `App.java` as a Java application from your IDE. The console will guide you through the different functionalities of the system.

## Components
- `App`: The main class that drives the user interface and integrates all components.
- `UserAuthenticator`: Manages user registration and authentication.
- `CartManager`: Handles operations related to the shopping cart.
- `Logger`: Provides a simple logging mechanism to the console.
- `Product`, `ProductFactory`, `ProductCatalog`: Interfaces and classes for product management.
- `PaymentProcessor`: Simulates payment processing.

## How to Use
After running `App.java`, follow the on-screen prompts in the console to interact with the system:
1. Register a new user
2. Login
3. View available products
4. Add products to the cart
5. Remove a product from the cart
6. View cart and checkout
7. Search products
8. Exit

## Contributing
Contributions to the Shopping System project are welcome. Please feel free to fork the repository, make your changes, and submit a pull request.

## License
This project is open-source and available under the MIT License. See the LICENSE file for more details.

## Acknowledgments
- This project is created as a part of a software engineering practice to demonstrate object-oriented design and implementation in Java.
