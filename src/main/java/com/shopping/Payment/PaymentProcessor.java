package com.shopping.Payment;

public class PaymentProcessor {

    private Logger logger;

    public PaymentProcessor(Logger logger) {
        this.logger = logger;
    }

    public boolean processPayment(double amount, PaymentDetails paymentDetails) {
        logger.log("Initiating payment process.");

        if (!validatePaymentDetails(paymentDetails)) {
            logger.log("Payment details validation failed.");
            return false;
        }
        
        if (amount <= 0) {
            logger.log("Invalid payment amount.");
            return false;
        }

        // Simulate contacting payment gateway
        logger.log("Contacting payment gateway for the transaction...");

        try {
            simulatePaymentGatewayProcessing();
            logger.log(String.format("Payment of $%.2f was successful using %s.", amount, paymentDetails.getPaymentMethod()));
            return true;
        } catch (PaymentProcessingException e) {
            logger.log("Payment failed: " + e.getMessage());
            return false;
        }
    }

    private boolean validatePaymentDetails(PaymentDetails paymentDetails) {
        // Implement validation logic here
        // For simplicity, checks are basic
        return paymentDetails != null && paymentDetails.isValid();
    }

    private void simulatePaymentGatewayProcessing() throws PaymentProcessingException {
        // Simulate a processing delay and potential failure
        try {
            Thread.sleep(2000); // Simulate delay
            if (Math.random() > 0.1) { // Simulate a 90% success rate
                // Payment successful
            } else {
                throw new PaymentProcessingException("Payment gateway error.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new PaymentProcessingException("Payment processing was interrupted.");
        }
    }
}

class PaymentDetails {
    private String paymentMethod;
    private String accountDetails; // Simplified representation

    public PaymentDetails(String paymentMethod, String accountDetails) {
        this.paymentMethod = paymentMethod;
        this.accountDetails = accountDetails;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isValid() {
        // Check for non-null and non-empty
        if (paymentMethod == null || paymentMethod.trim().isEmpty() || accountDetails == null || accountDetails.trim().isEmpty()) {
            return false;
        }
    
        // Simulate checking for valid payment methods
        if (!paymentMethod.equalsIgnoreCase("credit card") && !paymentMethod.equalsIgnoreCase("paypal")) {
            return false;
        }
    
        // Example of a simple format check for account details
        // For a credit card, we could simulate checking if it's all digits and of a certain length
        // Note: This is a very basic check and not secure or thorough for real use cases
        if (paymentMethod.equalsIgnoreCase("credit card")) {
            return accountDetails.matches("\\d{16}"); // Simplified: just checks for 16 digits
        }
    
        // Add more specific validations for other payment methods if necessary
    
        return true;
    }
    
}

class PaymentProcessingException extends Exception {
    public PaymentProcessingException(String message) {
        super(message);
    }
}

class Logger {
    public void log(String message) {
        // Log to console, file, or external service
        System.out.println(message);
    }
}