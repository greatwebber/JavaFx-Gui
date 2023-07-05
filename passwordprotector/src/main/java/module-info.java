module com.passwordprotector {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.passwordprotector to javafx.fxml;
    exports com.passwordprotector;
}
