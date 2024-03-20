package com.shopping;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class LoggerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Redirect System.out to capture output
    }

    @Test
    void testLog() {
        Logger logger = new Logger();
        String testMessage = "Test message";
        logger.log(testMessage);
        
        assertTrue(outputStreamCaptor.toString().trim().contains(testMessage), "The log method should output the message to System.out");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut); // Reset System.out to its original state
    }
}
