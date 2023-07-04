package com.currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Currency extends Application {
    private ComboBox<String> currencyComboBox;
    private TextField amountTextField;
    private Button convertButton;
    private Label resultLabel;

    // Exchange rates for different currencies (dummy data)
    private static final double USD_TO_EUR = 0.89;
    private static final double USD_TO_GBP = 0.75;
    private static final double USD_TO_JPY = 109.50;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Foreign Payment");

        // Create UI components
        currencyComboBox = new ComboBox<>();
        currencyComboBox.getItems().addAll("EUR", "GBP", "JPY");
        currencyComboBox.setValue("EUR");

        amountTextField = new TextField();

        convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convertCurrency());

        resultLabel = new Label();

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));

        gridPane.add(new Label("Currency:"), 0, 0);
        gridPane.add(currencyComboBox, 1, 0);

        gridPane.add(new Label("Amount:"), 0, 1);
        gridPane.add(amountTextField, 1, 1);

        HBox buttonContainer = new HBox(10);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().add(convertButton);
        gridPane.add(buttonContainer, 0, 2, 2, 1);

        VBox resultContainer = new VBox(10);
        resultContainer.setAlignment(Pos.CENTER);
        resultContainer.getChildren().add(resultLabel);
        gridPane.add(resultContainer, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertCurrency() {
        String selectedCurrency = currencyComboBox.getValue();
        double amount = Double.parseDouble(amountTextField.getText());

        double convertedAmount;
        String currencySymbol;

        // Convert amount based on selected currency
        switch (selectedCurrency) {
            case "EUR":
                convertedAmount = amount * USD_TO_EUR;
                currencySymbol = "€";
                break;
            case "GBP":
                convertedAmount = amount * USD_TO_GBP;
                currencySymbol = "£";
                break;
            case "JPY":
                convertedAmount = amount * USD_TO_JPY;
                currencySymbol = "¥";
                break;
            default:
                convertedAmount = amount;
                currencySymbol = "";
                break;
        }

        // Format the converted amount to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String formattedAmount = decimalFormat.format(convertedAmount);

        resultLabel.setText("Payment Amount: " + currencySymbol + formattedAmount + " " + selectedCurrency);
    }
}
