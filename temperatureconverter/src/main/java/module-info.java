module temperatureconverter {
    requires javafx.controls;
    requires javafx.fxml;

    opens temperatureconverter to javafx.fxml;
    exports temperatureconverter;
}
