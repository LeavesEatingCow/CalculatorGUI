module com.example.calculatorgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorgui to javafx.fxml;
    opens p1 to javafx.fxml;
    exports p1;
}