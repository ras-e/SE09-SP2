module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires com.jfoenix;
    requires AnimateFX;

    opens org.presentation to javafx.fxml;
    exports org.presentation;
}