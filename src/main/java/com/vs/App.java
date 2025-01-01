package com.vs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the sign-in scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignIn.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Sign In");
            primaryStage.setScene(new Scene(root));
            // Maximize the stage (window) on startup
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
