package agecalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends Application {
    private DatePicker datePicker;
    private Button calculateButton;

    public AgeCalculator() {
        // Default constructor
    }

    public AgeCalculator(String title) {
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
        primaryStage.setTitle("Age Calculator");

        // Create a grid pane to hold the UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a date picker
        datePicker = new DatePicker();
        datePicker.setPromptText("Select birth date");

        // Create a calculate button
        calculateButton = new Button("Calculate Age");
        calculateButton.setOnAction(e -> calculateAge());

        // Add components to the grid pane
        gridPane.add(new Label("Birth Date:"), 0, 0);
        gridPane.add(datePicker, 1, 0);
        gridPane.add(calculateButton, 1, 1);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateAge() {
        LocalDate birthDate = datePicker.getValue();
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        int years = age.getYears();
        int months = age.getMonths();
        int days = age.getDays();

        showAlert("Age Result", "Years: " + years + "\nMonths: " + months + "\nDays: " + days);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        AgeCalculator ageCalculator = new AgeCalculator("Age Calculator");
        ageCalculator.launchProgram();
    }
}
