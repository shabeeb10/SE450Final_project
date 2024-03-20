package com.shopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserAuthenticatorTest {

    private UserAuthenticator authenticator;

    @BeforeEach
    void setUp() {
        authenticator = new UserAuthenticator();
    }

    @Test
    void testRegisterAndLogin() {
        assertTrue(authenticator.register("user", "password"), "Registration should succeed for new user");
        assertFalse(authenticator.register("user", "password"), "Duplicate registration should fail");
        assertTrue(authenticator.login("user", "password"), "Login should succeed with correct credentials");
        assertFalse(authenticator.login("user", "wrong"), "Login should fail with incorrect password");
    }
}
