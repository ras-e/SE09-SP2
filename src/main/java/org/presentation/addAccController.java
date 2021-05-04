package org.presentation;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class addAccController {

    public TextField email;
    public TextField country;
    public TextField inProgram;
    public TextField name;
    public TextField date;
    public TextField role;
    public Button saveButton;
    public Button cancelButton;

    public void cancelAction(ActionEvent actionEvent) {
    closeStage();
    }

    public void saveButton(ActionEvent actionEvent) {


    }
    public void closeStage() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}

