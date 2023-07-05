import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BMICalculator extends Application {
    private TextField heightField;
    private TextField weightField;
    private Label resultLabel;

    public BMICalculator() {
        // Default constructor
    }

    public BMICalculator(String title) {
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
        primaryStage.setTitle("BMI Calculator");

        // Create a grid pane to hold the UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create text fields for height and weight
        heightField = new TextField();
        heightField.setPromptText("Enter height (in cm)");
        weightField = new TextField();
        weightField.setPromptText("Enter weight (in kg)");

        // Create a button for calculating BMI
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateBMI());

        // Create a label for displaying the result
        resultLabel = new Label();

        // Add components to the grid pane
        gridPane.add(new Label("Height:"), 0, 0);
        gridPane.add(heightField, 1, 0);
        gridPane.add(new Label("Weight:"), 0, 1);
        gridPane.add(weightField, 1, 1);
        gridPane.add(calculateButton, 1, 2);
        gridPane.add(resultLabel, 1, 3);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateBMI() {
        String heightText = heightField.getText();
        String weightText = weightField.getText();

        if (!heightText.isEmpty() && !weightText.isEmpty()) {
            double height = Double.parseDouble(heightText);
            double weight = Double.parseDouble(weightText);

            double bmi = calculateBMI(height, weight);
            String result = String.format("Your BMI: %.2f", bmi);
            resultLabel.setText(result);
        } else {
            resultLabel.setText("Please enter valid height and weight");
        }
    }

    private double calculateBMI(double height, double weight) {
        // Calculate BMI using the formula: BMI = weight (kg) / height^2 (m^2)
        double heightInMeters = height / 100; // Convert height from cm to meters
        return weight / (heightInMeters * heightInMeters);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        BMICalculator bmiCalculator = new BMICalculator("BMI Calculator");
        bmiCalculator.launchProgram();
    }
}
