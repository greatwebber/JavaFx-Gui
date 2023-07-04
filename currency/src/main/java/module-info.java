module com.currency {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.currency to javafx.fxml;
    exports com.currency;
}
