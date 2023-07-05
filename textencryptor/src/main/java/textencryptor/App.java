package textencryptor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextEncryptor extends Application {
    private TextArea inputTextArea;
    private TextArea outputTextArea;
    private Button encryptButton;
    private Button decryptButton;

    public TextEncryptor() {
        // Default constructor
    }

    public TextEncryptor(String title) {
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
        primaryStage.setTitle("Text Encryptor");

        // Create a grid pane to hold the UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a text area for input text
        inputTextArea = new TextArea();
        inputTextArea.setPromptText("Enter text to encrypt/decrypt");
        inputTextArea.setPrefColumnCount(20);
        inputTextArea.setPrefRowCount(10);

        // Create a text area for displaying the encrypted/decrypted text
        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setPrefColumnCount(20);
        outputTextArea.setPrefRowCount(10);

        // Create encrypt and decrypt buttons
        encryptButton = new Button("Encrypt");
        encryptButton.setOnAction(e -> encryptText());
        decryptButton = new Button("Decrypt");
        decryptButton.setOnAction(e -> decryptText());

        // Add components to the grid pane
        gridPane.add(new Label("Input:"), 0, 0);
        gridPane.add(inputTextArea, 1, 0);
        gridPane.add(new Label("Output:"), 0, 1);
        gridPane.add(outputTextArea, 1, 1);
        gridPane.add(encryptButton, 0, 2);
        gridPane.add(decryptButton, 1, 2);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void encryptText() {
        String inputText = inputTextArea.getText();
        String encryptedText = encryptText(inputText);
        outputTextArea.setText(encryptedText);
    }

    private void decryptText() {
        String inputText = inputTextArea.getText();
        String decryptedText = decryptText(inputText);
        outputTextArea.setText(decryptedText);
    }

    private String encryptText(String text) {
        // Encryption logic
        // Implement your encryption algorithm here
        return "Encrypted: " + text;
    }

    private String decryptText(String text) {
        // Decryption logic
        // Implement your decryption algorithm here
        return "Decrypted: " + text;
    }

    public static void main(String[] args) {
        TextEncryptor textEncryptor = new TextEncryptor("Text Encryptor");
        textEncryptor.launchProgram();
    }
}
