package org.presentation;

import animatefx.animation.ZoomIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Objects;

public class guestController {

    @FXML
    private Button btnLogin;

    @FXML
    private void goLoginPage (MouseEvent event) {
        if(event.getSource() == btnLogin) {
            closeStage();
            loadWindow("login.fxml","Login");
        }
    }

    void loadWindow(String path, String title)
    {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeStage() {
        ((Stage) btnLogin.getScene().getWindow()).close();
    }
}
