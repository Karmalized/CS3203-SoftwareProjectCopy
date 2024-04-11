module com.calorieminder.calorieminder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.calorieminder.calorieminder to javafx.fxml;
    exports com.calorieminder.calorieminder;
}