package triangleareacalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TriangleAreaCalculator extends Application {
    private TextField baseField;
    private TextField heightField;
    private Button calculateButton;

    public TriangleAreaCalculator() {
        // Default constructor
    }

    public TriangleAreaCalculator(String title) {
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
        primaryStage.setTitle("Triangle Area Calculator");

        // Create a grid pane to hold the UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create text fields for base and height
        baseField = new TextField();
        baseField.setPromptText("Enter base length");
        heightField = new TextField();
        heightField.setPromptText("Enter height");

        // Create a calculate button
        calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateArea());

        // Add components to the grid pane
        gridPane.add(new Label("Base:"), 0, 0);
        gridPane.add(baseField, 1, 0);
        gridPane.add(new Label("Height:"), 0, 1);
        gridPane.add(heightField, 1, 1);
        gridPane.add(calculateButton, 1, 2);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateArea() {
        String baseText = baseField.getText();
        String heightText = heightField.getText();

        double base = Double.parseDouble(baseText);
        double height = Double.parseDouble(heightText);

        double area = calculateArea(base, height);
        showAlert("Triangle Area", "The area of the triangle is: " + area);
    }

    private double calculateArea(double base, double height) {
        return 0.5 * base * height;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        TriangleAreaCalculator areaCalculator = new TriangleAreaCalculator("Triangle Area Calculator");
        areaCalculator.launchProgram();
    }
}
