package temperatureconverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TemperatureConverter extends Application {
    private TextField inputField;
    private Button convertButton;
    private Label resultLabel;

    public TemperatureConverter() {
        // Default constructor
    }

    public TemperatureConverter(String title) {
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
        primaryStage.setTitle("Temperature Converter");

        // Create a VBox to hold the UI components
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        // Create an input field for temperature
        inputField = new TextField();
        inputField.setPromptText("Enter temperature");

        // Create a convert button
        convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convertTemperature());

        // Create a label to display the result
        resultLabel = new Label();

        // Add components to the VBox
        vbox.getChildren().addAll(inputField, convertButton, resultLabel);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            double celsius = convertToFahrenheit(temperature);
            double fahrenheit = convertToCelsius(temperature);
            resultLabel.setText("Celsius: " + celsius + "\nFahrenheit: " + fahrenheit);
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid input. Please enter a valid number.");
        }
        inputField.clear();
    }

    private double convertToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        TemperatureConverter temperatureConverter = new TemperatureConverter("Temperature Converter");
        temperatureConverter.launchProgram();
    }
}
