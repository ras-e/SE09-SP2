module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens org.presentation to javafx.fxml;
    exports org.presentation;
}