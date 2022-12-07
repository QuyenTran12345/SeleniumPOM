module com.example.seleniumpom {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seleniumpom to javafx.fxml;
    exports com.example.seleniumpom;
}