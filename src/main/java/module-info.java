module com.calorieminder.calorieminder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires json.simple;
    requires java.compiler;
    requires com.opencsv;


    opens com.calorieminder.calorieminder to javafx.fxml;
    exports com.calorieminder.calorieminder;
}