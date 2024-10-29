module com.example.assignment8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment8 to javafx.fxml;
    exports com.example.assignment8;
}