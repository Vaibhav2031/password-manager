package com.vs.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

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
    private void handleSignUp() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Handle sign-up logic here
        if (password.equals(confirmPassword)) {
            System.out.println("Sign Up - Username: " + username + ", Password: " + password);
        } else {
            System.out.println("Passwords do not match!");
        }
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
