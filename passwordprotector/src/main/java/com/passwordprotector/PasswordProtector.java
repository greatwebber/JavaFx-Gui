package com.passwordprotector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PasswordProtector extends Application {
    private PasswordField passwordField;
    private Button submitButton;

    public PasswordProtector() {
        // Default constructor
    }

    public PasswordProtector(String title) {
        // Constructor with a title parameter
        Stage stage = new Stage();
        stage.setTitle(title);
        start(stage);
    }

    public void launchProgram() {
        // Method to launch the program
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Protector");

        // Create a grid pane to hold the UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        // Create a submit button
        submitButton = new Button("Submit");
        submitButton.setOnAction(e -> verifyPassword());

        // Add components to the grid pane
        gridPane.add(new Label("Password:"), 0, 0);
        gridPane.add(passwordField, 1, 0);
        gridPane.add(submitButton, 1, 1);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void verifyPassword() {
        String password = passwordField.getText();
        if (password.equals("password123")) {
            showAlert("Success", "Correct password entered!");
        } else {
            showAlert("Error", "Incorrect password entered!");
        }
        passwordField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        PasswordProtector passwordProtector = new PasswordProtector("Password Protector");
        passwordProtector.launchProgram();
    }
}
