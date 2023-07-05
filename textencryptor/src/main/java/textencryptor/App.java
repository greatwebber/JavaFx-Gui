package textencryptor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FactorialCalculator extends Application {
    private TextField inputField;
    private Label resultLabel;

    public FactorialCalculator() {
        // Default constructor
    }

    public FactorialCalculator(String title) {
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
        primaryStage.setTitle("Factorial Calculator");

        // Create a grid pane to hold the UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create an input field for number entry
        inputField = new TextField();
        inputField.setPromptText("Enter a number");

        // Create a button to calculate the factorial
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateFactorial());

        // Create a label to display the result
        resultLabel = new Label();

        // Add components to the grid pane
        gridPane.add(new Label("Number:"), 0, 0);
        gridPane.add(inputField, 1, 0);
        gridPane.add(calculateButton, 1, 1);
        gridPane.add(resultLabel, 0, 2, 2, 1);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateFactorial() {
        try {
            int number = Integer.parseInt(inputField.getText());
            long factorial = factorial(number);
            resultLabel.setText("Factorial: " + factorial);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    private long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    private long factorial(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        long result = 1;
        for (long i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialCalculator factorialCalculator = new FactorialCalculator("Factorial Calculator");
        factorialCalculator.launchProgram();
    }
}
