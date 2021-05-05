package org.presentation;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class addProgramController {

    @FXML
    private Button cancelButton;

    public void cancelAction(ActionEvent actionEvent) {
        closeStage();
    }
    
    public void closeStage() { ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
