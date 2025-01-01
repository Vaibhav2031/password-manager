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

public class SignInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Hyperlink goToSignUpButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleSignIn() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Handle sign-in logic here
        System.out.println("Sign In - Username: " + username + ", Password: " + password);

        // Get hashed password from database for the given username
        String envFile = ".env.development"; // Pending to be fixed
        UserRepository userRepository = new UserRepository(envFile);
        User user = userRepository.getUser(username);
        if (user != null) {
            String salt = user.getSalt();
            String hashPassword = user.getHashPassword();
            // Check if the password is correct
            if (PasswordUtils.verifyUserPassword(password, hashPassword, salt)) {
                statusLabel.setText("Sign in successful!");
            } else {
                statusLabel.setText("Invalid password. Please try again.");
            }
        } else {
            statusLabel.setText("User not found. Please sign up.");
        }
    }

    @FXML
    private void goToSignUp() {
        try {
            // Load the sign-up scene
            System.out.println("Go to Sign Up");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
            System.out.println("signup loaded");
            Parent root = loader.load();
            Stage stage = (Stage) goToSignUpButton.getScene().getWindow();
            stage.setScene(new Scene(root, 1600, 800));
            // Maximize the stage (window) on startup
            stage.setMaximized(true);
            stage.setTitle("Sign Up");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
