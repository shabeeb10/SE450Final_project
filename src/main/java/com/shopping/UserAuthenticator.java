package com.shopping;

import java.util.HashMap;
import java.util.Map;

public class UserAuthenticator {
    private Map<String, String> users = new HashMap<>();
    public boolean login(String username, String password) {
        // Check if user exists and password matches
        if (users.containsKey(username)) {
            String storedPassword = users.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    public boolean register(String username, String password) {
       // Check if username is already taken
       if (users.containsKey(username)) {
        return false; // Username is taken
    }
    // Register new user
    users.put(username, password);
    return true;
    }
}