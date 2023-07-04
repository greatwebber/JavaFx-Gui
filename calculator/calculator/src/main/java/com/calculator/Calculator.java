package com.calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    private TextField inputField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane gridPane = createGridPane();
        addInputField(gridPane);
        addButtons(gridPane);

        Scene scene = new Scene(gridPane, 200, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        return gridPane;
    }

    private void addInputField(GridPane gridPane) {
        inputField = new TextField();
        inputField.setEditable(false);
        gridPane.add(inputField, 0, 0, 4, 1);
    }

    private void addButtons(GridPane gridPane) {
        Button btn0 = createNumberButton("0", 1, 4);
        Button btn1 = createNumberButton("1", 0, 1);
        Button btn2 = createNumberButton("2", 1, 1);
        Button btn3 = createNumberButton("3", 2, 1);
        Button btn4 = createNumberButton("4", 0, 2);
        Button btn5 = createNumberButton("5", 1, 2);
        Button btn6 = createNumberButton("6", 2, 2);
        Button btn7 = createNumberButton("7", 0, 3);
        Button btn8 = createNumberButton("8", 1, 3);
        Button btn9 = createNumberButton("9", 2, 3);

        Button btnPlus = createOperatorButton("+", 3, 1);
        Button btnMinus = createOperatorButton("-", 3, 2);
        Button btnMultiply = createOperatorButton("*", 3, 3);
        Button btnDivide = createOperatorButton("/", 3, 4);
        Button btnClear = createClearButton("C", 0, 4);
        Button btnEquals = createEqualsButton("=", 2, 4);

        gridPane.getChildren().addAll(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
                btnPlus, btnMinus, btnMultiply, btnDivide, btnClear, btnEquals);
    }

    private Button createNumberButton(String label, int colIndex, int rowIndex) {
        Button button = new Button(label);
        button.setPrefSize(40, 40);
        button.setOnAction(this::handleNumberButtonClick);
        GridPane.setConstraints(button, colIndex, rowIndex);
        return button;
    }

    private Button createOperatorButton(String label, int colIndex, int rowIndex) {
        Button button = new Button(label);
        button.setPrefSize(40, 40);
        button.setOnAction(this::handleOperatorButtonClick);
        GridPane.setConstraints(button, colIndex, rowIndex);
        return button;
    }

    private Button createClearButton(String label, int colIndex, int rowIndex) {
        Button button = new Button(label);
        button.setPrefSize(40, 40);
        button.setOnAction(this::handleClearButtonClick);
        GridPane.setConstraints(button, colIndex, rowIndex);
        return button;
    }

    private Button createEqualsButton(String label, int colIndex, int rowIndex) {
        Button button = new Button(label);
        button.setPrefSize(40, 40);
        button.setOnAction(this::handleEqualsButtonClick);
        GridPane.setConstraints(button, colIndex, rowIndex);
        return button;
    }

    private void handleNumberButtonClick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        inputField.appendText(value);
    }

    private void handleOperatorButtonClick(ActionEvent event) {
        String operator = ((Button) event.getSource()).getText();
        inputField.appendText(" " + operator + " ");
    }

    private void handleClearButtonClick(ActionEvent event) {
        inputField.clear();
    }

    private void handleEqualsButtonClick(ActionEvent event) {
        String expression = inputField.getText();
        String[] parts = expression.split(" ");
        if (parts.length != 3) {
            inputField.setText("Invalid expression");
            return;
        }

        double operand1;
        double operand2;
        try {
            operand1 = Double.parseDouble(parts[0]);
            operand2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            inputField.setText("Invalid expression");
            return;
        }

        double result = 0;
        switch (parts[1]) {
            case "+":
                result = add(operand1, operand2);
                break;
            case "-":
                result = subtract(operand1, operand2);
                break;
            case "*":
                result = multiply(operand1, operand2);
                break;
            case "/":
                result = divide(operand1, operand2);
                break;
            default:
                inputField.setText("Invalid operator");
                return;
        }

        inputField.setText(Double.toString(result));
    }

    private double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private double divide(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
