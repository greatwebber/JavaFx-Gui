module agecalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens agecalculator to javafx.fxml;
    exports agecalculator;
}
