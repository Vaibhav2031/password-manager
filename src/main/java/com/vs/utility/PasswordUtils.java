package com.vs.utility;

import java.security.SecureRandom;
import java.util.Base64;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordUtils{
    // Method to generate a random salt
    public static String generateSalt() {
        // Create an instance of SecureRandom
        SecureRandom secureRandom = new SecureRandom();

        // Create a byte array to hold the salt
        byte[] salt = new byte[16]; // 16 bytes of salt

        // Generate random bytes for the salt
        secureRandom.nextBytes(salt);

        // Encode the salt as a Base64 string (optional, for easy storage)
        return Base64.getEncoder().encodeToString(salt);
        // Private constructor to prevent instantiation
    }

    private PasswordUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String hashPassword(String password, String salt) {
        Argon2 argon2 = Argon2Factory.create();

        // Configure Argon2 parameters (optional)
        int iterations = 2; // Number of iterations
        int memory = 65536; // Memory in KB
        int parallelism = 1; // Number of parallel threads

        // Combine password and salt before hashing
        String combined = password + salt;

        // Hash the password with Argon2
        return argon2.hash(iterations, memory, parallelism, combined);
    }

}
