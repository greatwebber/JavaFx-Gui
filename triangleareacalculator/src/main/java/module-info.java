module triangleareacalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens triangleareacalculator to javafx.fxml;
    exports triangleareacalculator;
}
