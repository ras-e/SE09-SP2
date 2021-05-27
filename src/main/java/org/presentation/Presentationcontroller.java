package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Presentationcontroller {

    public void changewindow(String fxml, String stagetitle) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(stagetitle);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException ex) {
        }

    }


}
