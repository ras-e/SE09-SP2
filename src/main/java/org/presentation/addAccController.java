package org.presentation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class addAccController {

    public JFXTextField email;
    public JFXTextField country;
    public JFXTextField inProgram;
    public JFXTextField name;
    public JFXTextField date;
    public JFXTextField role;
    public JFXButton saveButton;
    public JFXButton cancelButton;

    public void cancelAction(ActionEvent actionEvent) {
    closeStage();
    }

    public void saveButton(ActionEvent actionEvent) {


    }
    public void closeStage() { ((Stage) cancelButton.getScene().getWindow()).close();
    }
}

