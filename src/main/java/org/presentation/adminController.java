package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class adminController {
    public void loadAddMemberUI(MouseEvent mouseEvent) {
        loadWindow("addAcc.fxml", "Add New Acc");
    }

    public void loadDeleteMemberUI(ActionEvent actionEvent) {
    }

    public void loadEditMemberUI(ActionEvent actionEvent) {
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
}