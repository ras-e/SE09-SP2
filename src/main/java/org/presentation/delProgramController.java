package org.presentation;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class delProgramController {
    @FXML
    private JFXButton cancelButton;

    public void cancelAction(ActionEvent actionEvent) {
        closeStage();
    }

    public void saveButton(ActionEvent actionEvent) {


    }
    private void closeStage() { ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
