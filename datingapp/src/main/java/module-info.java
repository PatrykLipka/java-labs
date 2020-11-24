module datingapp {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens pl.polsl.lab.datingapp.controller to javafx.fxml;
    opens pl.polsl.lab.datingapp;   
}