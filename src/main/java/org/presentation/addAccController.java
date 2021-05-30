package org.presentation;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class addAccController {

    public TextField email;
    public TextField country;
    public TextField inProgram;
    public TextField name;
    public TextField date;
    public TextField role;
    public JFXButton saveButton;
    public JFXButton cancelButton;

    public void cancelAction(ActionEvent actionEvent) {
    closeStage();
    }

    public void saveButton(ActionEvent actionEvent) {
    }
    private void closeStage() { ((Stage) cancelButton.getScene().getWindow()).close();
    }

    public void initialize(){
        System.out.println("add account controller");
    }
}

