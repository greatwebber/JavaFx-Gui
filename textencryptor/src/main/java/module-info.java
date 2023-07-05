module textencryptor {
    requires javafx.controls;
    requires javafx.fxml;

    opens textencryptor to javafx.fxml;
    exports textencryptor;
}
