module com.bmi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bmi to javafx.fxml;
    exports com.bmi;
}
