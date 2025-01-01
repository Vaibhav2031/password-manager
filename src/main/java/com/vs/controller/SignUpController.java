package com.vs.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import com.vs.model.User;
import com.vs.repository.UserRepository;
import com.vs.utility.PasswordUtils;

public class SignUpController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Hyperlink goToSignInButton;

    @FXML
    private Label statusLabel;

    String salt;

    @FXML
    private void handleSignUp() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Handle sign-up logic here
        if (password.equals(confirmPassword)) {
            System.out.println("Sign Up - Username: " + username + ", Password: " + password);
            // Store credentials
            boolean success = storeCredentials(username, password);

            // Update label based on success
            if (success) {
                statusLabel.setText("Registration successful! Please Sign In.");
            } else {
                statusLabel.setText("Registration failed. Try again.");
            }
        } else {
            System.out.println("Passwords do not match!");
        }
    }

    private boolean storeCredentials(String username, String password) {
        salt = PasswordUtils.generateSalt();
        String hashedPassword = PasswordUtils.hashPassword(password, salt);
        // Pending : Need to update in build configuration remove hardcoded value
        // Specify the .env file to load
        String envFile = ".env.development"; // or ".env.production" for production
        UserRepository userRepository = new UserRepository(envFile);
        User user = new User(username, salt, hashedPassword);
        userRepository.createUser(user);
        return true;
    }

    @FXML
    private void goToSignIn() {
        try {
            // Load the sign-in scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignIn.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) goToSignInButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.setTitle("Sign In");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
