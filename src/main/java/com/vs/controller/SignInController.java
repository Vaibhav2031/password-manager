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
    private void handleSignIn() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Handle sign-in logic here
        System.out.println("Sign In - Username: " + username + ", Password: " + password);
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
            stage.setScene(new Scene(root,1600,800));
            // Maximize the stage (window) on startup
            stage.setMaximized(true);
            stage.setTitle("Sign Up");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
