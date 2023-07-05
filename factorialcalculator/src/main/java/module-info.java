module factorialcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens factorialcalculator to javafx.fxml;
    exports factorialcalculator;
}
